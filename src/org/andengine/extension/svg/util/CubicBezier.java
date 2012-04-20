package org.andengine.extension.svg.util;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public final class CubicBezier {
	private static final Vector2 tmpVec = new Vector2();
	
	public static final void cubicBezier(final List<Vector2> pVertices, final int pSegments, final Vector2 p0, final Vector2 p1, final Vector2 p2, final Vector2 p3){
		if(pSegments !=0){
			final float stepsLen = Math.round(1000f/pSegments)/1000f;
			for(float i=1;i<pSegments;i++){
				pVertices.add(CubicBezier.cubicBezierPoint(p0,p1,p2,p3,i*stepsLen).cpy());
			}
			
		}
		pVertices.add(p3.cpy());
	}
	public static final Vector2 cubicBezierPoint(final Vector2 p0, final Vector2 p1, final Vector2 p2, final Vector2 p3, final float t){
		//- B(t) = (1-t)^3*pen + 3*(1-t)^2*t*points[0] + 3*(1-t)*t^2*points[1] + t^3*points[2]
		final float onemint = 1f-t;
		
		CubicBezier.tmpVec.x = onemint * onemint * onemint * p0.x + 
						3f * onemint * onemint * t * p1.x + 
						3f * onemint * t * t * p2.x +
						t * t * t * p3.x;
		CubicBezier.tmpVec.y = onemint * onemint * onemint * p0.y + 
						3f * onemint * onemint * t * p1.y + 
						3f * onemint * t * t * p2.y +
						t * t * t * p3.y;
		
		return CubicBezier.tmpVec;
	}
}
