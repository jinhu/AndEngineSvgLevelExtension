package org.andengine.extension.svg.util;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import org.andengine.entity.shape.Shape;
import org.andengine.util.math.MathUtils;

import com.badlogic.gdx.math.Vector2;

public final class SVGMathUtils {
	
	//-- Shape
	
	public static final float[] PointToObjectWorld(final Shape pObject,float[] point){
		point = MathUtils.rotateAndScaleAroundCenter(point, pObject.getRotation(), 0, 0, pObject.getScaleX(), pObject.getScaleY(), 0, 0);
		point[0] += pObject.getX();
		point[1] += pObject.getY();
		return point;
	} 
	
	public static final void VectorToObjectWorld(final Shape pObject,final Vector2 pVec){
		float[] point = SVGMathUtils.vector2ToFloat(pVec);
		point = SVGMathUtils.PointToObjectWorld(pObject,point);
		SVGMathUtils.floatIntoVector2(point,pVec);
	} 
	
	public static final void ShapeToObjectWorld(final Shape pObject, final Shape pShape){
		
		float[] point = new float[2];
		point[0] = pShape.getX();
		point[1] = pShape.getY();
		point = SVGMathUtils.PointToObjectWorld(pObject,point);
		
		// repos to scale and rotate center
		float[] point2 = new float[2];
		point2 = point.clone();
		point2 = MathUtils.rotateAndScaleAroundCenter(
			point2, 
			pObject.getRotation() + pShape.getRotation(), 
			point[0] + pShape.getRotationCenterX(),
			point[1] + pShape.getRotationCenterY(), 
			pObject.getScaleX() * pShape.getScaleX(), 
			pObject.getScaleY() * pShape.getScaleY(),
			point[0] + pShape.getScaleCenterX(),
			point[1] + pShape.getScaleCenterY()
		);
		pShape.setPosition(point[0] + (point[0]-point2[0]), point[1] + (point[1]-point2[1]));
		
		pShape.setScale(pObject.getScaleX() * pShape.getScaleX(), pObject.getScaleY() * pShape.getScaleY());
		pShape.setRotation(pObject.getRotation()  + pShape.getRotation());
	}
	
	//-- Transform Doc (analog to Shape Transform maybe bring together)
	
	public static final float[] PointToObjectWorld(final TransformDoc pTDoc,float[] point){
		point = MathUtils.rotateAndScaleAroundCenter(point, pTDoc.getRotation(), 0, 0, pTDoc.getScaleX(), pTDoc.getScaleY(), 0, 0);
		point[0] += pTDoc.getX();
		point[1] += pTDoc.getY();
		return point;
	} 
	
	public static final void VectorToObjectWorld(final TransformDoc pTDoc,final Vector2 pVec){
		float[] point = SVGMathUtils.vector2ToFloat(pVec);
		point = SVGMathUtils.PointToObjectWorld(pTDoc,point);
		SVGMathUtils.floatIntoVector2(point,pVec);
	} 
	
	public static final void ShapeToObjectWorld(final TransformDoc pTDoc, final Shape pShape){
		
		float[] point = new float[2];
		point[0] = pShape.getX();
		point[1] = pShape.getY();
		point = SVGMathUtils.PointToObjectWorld(pTDoc,point);
		
		// repos to scale and rotate center
		float[] point2 = new float[2];
		point2 = point.clone();
		point2 = MathUtils.rotateAndScaleAroundCenter(
			point2, 
			pTDoc.getRotation() + pShape.getRotation(), 
			point[0] + pShape.getRotationCenterX(),
			point[1] + pShape.getRotationCenterY(), 
			pTDoc.getScaleX() * pShape.getScaleX(), 
			pTDoc.getScaleY() * pShape.getScaleY(),
			point[0] + pShape.getScaleCenterX(),
			point[1] + pShape.getScaleCenterY()
		);
		pShape.setPosition(point[0] + (point[0]-point2[0]), point[1] + (point[1]-point2[1]));
		
		pShape.setScale(pTDoc.getScaleX() * pShape.getScaleX(), pTDoc.getScaleY() * pShape.getScaleY());
		pShape.setRotation(pTDoc.getRotation()  + pShape.getRotation());
	}
	
	public static final void DocToObjectWorld(final TransformDoc pTDoc, final TransformDoc pDoc){
		
		float[] point = new float[2];
		point[0] = pDoc.getX();
		point[1] = pDoc.getY();
		point = SVGMathUtils.PointToObjectWorld(pTDoc,point);
		
		// repos to scale and rotate center
		float[] point2 = new float[2];
		point2 = point.clone();
		point2 = MathUtils.rotateAndScaleAroundCenter(
			point2, 
			pTDoc.getRotation() + pDoc.getRotation(), 
			point[0] + pDoc.getRotationCenterX(),
			point[1] + pDoc.getRotationCenterY(), 
			pTDoc.getScaleX() * pDoc.getScaleX(), 
			pTDoc.getScaleY() * pDoc.getScaleY(),
			point[0] + pDoc.getScaleCenterX(),
			point[1] + pDoc.getScaleCenterY()
		);
		pDoc.setPosition(point[0] + (point[0]-point2[0]), point[1] + (point[1]-point2[1]));
		
		pDoc.setScale(pTDoc.getScaleX() * pDoc.getScaleX(), pTDoc.getScaleY() * pDoc.getScaleY());
		pDoc.setRotation(pTDoc.getRotation()  + pDoc.getRotation());
	}
	
	//-- utils
	
	public static final float[] vector2ToFloat(final Vector2 pVec){
		float[] point = new float[2];
		point[0] = pVec.x;
		point[1] = pVec.y;
		return point;
	}
	
	public static final Vector2 floatToVector2(final float[] pFloat){
		return new Vector2(pFloat[0],pFloat[1]);
	}
	
	public static final void floatIntoVector2(final float[] pFloat, final Vector2 pVec){
		pVec.x = pFloat[0];
		pVec.y = pFloat[1];
	}
	
	public static float hex2float(String pHex){
		return (float) Integer.parseInt(pHex, 16 ) / 255;
	}
}
