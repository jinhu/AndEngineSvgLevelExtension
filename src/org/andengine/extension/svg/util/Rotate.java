package org.andengine.extension.svg.util;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import org.andengine.util.math.MathUtils;

public final class Rotate {
	
	public static final void transformDoc(final TransformDoc pDoc, final float pAngle, final float pCenterX, final float pCenterY) {
		//-- SVG transformation whole doc
		// rotate center to doc
		float[] center = new float[2];
		center[0] = pCenterX;
		center[1] = pCenterY;
		center = SVGMathUtils.PointToObjectWorld(pDoc, center);
		// rotate doc around rotate center
		float[] point = new float[2];
		point[0] = pDoc.getX();
		point[1] = pDoc.getY();
		point = MathUtils.rotateAroundCenter(point, pAngle, center[0], center[1]);
		pDoc.setPosition(point[0], point[1]);
		pDoc.setRotation(pDoc.getRotation() + pAngle);
		//Log.e("rotateDoc","x="+this.center[0]+" y="+this.center[1]+" rot="+shape.getRotation());
	}
}
