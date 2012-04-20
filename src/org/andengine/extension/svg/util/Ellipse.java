package org.andengine.extension.svg.util;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import java.util.List;

import org.andengine.util.math.MathUtils;

import com.badlogic.gdx.math.Vector2;

public final class Ellipse {
	private static final Vector2 tmpVec = new Vector2();
	
	public static final void ellipse(final List<Vector2> pVertices, final int pSegments, final Vector2 center, final float rx, final float ry, final float angle, final float stratAngle, final float deltaAngle){
		if(pSegments!=0){
			final float stepsLen = deltaAngle/pSegments;
			for(float i=1;i<pSegments;i++){
				pVertices.add(Ellipse.ellipsePoint(center, rx, ry, angle, stratAngle+i*stepsLen).cpy());
			}
		}
		pVertices.add(Ellipse.ellipsePoint(center, rx, ry, angle, stratAngle+deltaAngle));
	}
	
	public static final Vector2 ellipsePoint(final Vector2 center, final float rx, final float ry, final float angle, final float currAngle){
		// angle in rad, currentAngle in deg
		final float cosA = (float) Math.cos(angle);
		final float sinA = (float) Math.sin(angle);
		final float caRad = MathUtils.degToRad(currAngle);
		final float cosCArx = (float) Math.cos(caRad) * rx;
		final float sinCAry = (float) Math.sin(caRad) * ry;
		
		Ellipse.tmpVec.x = cosA * cosCArx + -sinA * sinCAry + center.x;
		Ellipse.tmpVec.y = sinA * cosCArx + cosA * sinCAry + center.y;
		return Ellipse.tmpVec;
	}
}
