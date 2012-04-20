package org.andengine.extension.svg.util;

import java.util.List;

import org.andengine.entity.shape.Shape;

import com.badlogic.gdx.math.Vector2;

public class TransformDoc {
	private float mX;
	private float mY;
	private float mRotation;	
	private float mScaleX;
	private float mScaleY;
	
	public TransformDoc(){
		this.mScaleX = 1;
		this.mScaleY = 1;
	}
	
	public void setPosition(final float pX, final float pY){
		this.mX = pX;
		this.mY = pY;
	}
	
	public void setRotation(final float pRotation){
		this.mRotation = pRotation;
	}
	
	public void setScale(final float pScaleX, final float pScaleY){
		this.mScaleX = pScaleX;
		this.mScaleY = pScaleY;
	}
	
	public float getX(){
		return this.mX;
	}
	
	public float getY(){
		return this.mY;
	}
	
	public float getRotation(){
		return this.mRotation;
	}
	
	public float getScaleX(){
		return this.mScaleX;
	}
	
	public float getScaleY(){
		return this.mScaleY;
	}
	
	public float getRotationCenterX(){
		return 0;
	}
	
	public float getRotationCenterY(){
		return 0;
	}
	
	public float getScaleCenterX(){
		return 0;
	}
	
	public float getScaleCenterY(){
		return 0;
	}
	
	//-- Transformation Stuff
	
	public void transformShape(Shape pShape){	
		if(this.isTransformed()){
			SVGMathUtils.ShapeToObjectWorld(this, pShape);
		}
	}
	
	public void transformDoc(TransformDoc pDoc){	
		if(this.isTransformed()){
			SVGMathUtils.DocToObjectWorld(this, pDoc);
		}
	}
	
	public void transformVertices(List<Vector2> pVertices){
		if(this.isTransformed()){
			for(int i=0;i<pVertices.size();i++){
				SVGMathUtils.VectorToObjectWorld(this, pVertices.get(i));
			}
		}
	}
	
	public boolean isScaled(){
		return this.mScaleX!=1 || this.mScaleY!=1;
	}
	
	public boolean isRotated(){
		return this.mRotation!=0;
	}
	
	public boolean isTranslated(){
		return this.mX!=0 || this.mY!=0;
	}
	
	public boolean isTransformed(){
		return this.isScaled() || this.isRotated() || this.isTranslated();
	}
	
	public void toIdent(){
		this.mScaleX = this.mScaleY = 1;
		this.mX = this.mY = this.mRotation = 0;
	}
}
