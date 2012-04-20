package org.andengine.extension.svg.util;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public final class QuadraticBezier {
	private static final Vector2 tmpVec = new Vector2();
	
	public static final void quadraticBezier(final List<Vector2> pVertices, final int pSegments, final Vector2 p0, final Vector2 p1, final Vector2 p2){
		if(pSegments!=0){
			final float stepsLen = Math.round(1000f/pSegments)/1000f;
			for(float i=1;i<pSegments;i++){
				pVertices.add(QuadraticBezier.quadraticBezierPoint(p0,p1,p2,i*stepsLen).cpy());
			}
			
		}
		pVertices.add(p2.cpy());
	}
	
	public static final Vector2 quadraticBezierPoint(final Vector2 p0, final Vector2 p1, final Vector2 p2, final float t){
		final float onemint = 1f-t;
		
		QuadraticBezier.tmpVec.x = onemint * onemint * p0.x + 
						2f * onemint * t * p1.x + 
						t * t * p2.x;
		QuadraticBezier.tmpVec.y = onemint * onemint * p0.y + 
						2f * onemint * t * p1.y + 
						t * t * p2.y;
		return QuadraticBezier.tmpVec;
	}
}
