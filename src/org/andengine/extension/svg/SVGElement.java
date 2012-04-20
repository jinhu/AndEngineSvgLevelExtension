package org.andengine.extension.svg;

import org.andengine.entity.shape.Shape;

import com.badlogic.gdx.physics.box2d.Body;

public class SVGElement {
	private Body mBody;
	private Shape mShape;
	
	public SVGElement(){}
	
	public SVGElement(final Shape pShape, final Body pBody){
		this.mBody = pBody;
		this.mShape = pShape;
	}
	
	public Shape getShape(){
		return this.mShape;
	}
	
	public Body getBody(){
		return this.mBody;
	}
	
	public void setBody(final Body pBody){
		this.mBody = pBody;
	}
	
	public void setShape(final Shape pShape){
		this.mShape = pShape;
	}
	
	public boolean hasShape(){
		return this.mShape!=null;
	}
	
	public boolean hasBody(){
		return this.mBody!=null;
	}
}
