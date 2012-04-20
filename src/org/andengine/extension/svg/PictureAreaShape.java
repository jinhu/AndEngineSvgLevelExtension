package org.andengine.extension.svg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.entity.modifier.IEntityModifier.IEntityModifierMatcher;
import org.andengine.entity.shape.IAreaShape;
import org.andengine.entity.shape.IShape;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.shader.ShaderProgram;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.util.GLState;
import org.andengine.opengl.vbo.IVertexBufferObject;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.adt.transformation.Transformation;
import org.andengine.util.color.Color;

import android.graphics.Picture;

public class PictureAreaShape implements IAreaShape {

	private Picture mPicture;

	public PictureAreaShape(Picture currentPucture,
			VertexBufferObjectManager vertexBufferObjectManager) {
		mPicture = currentPucture;
	}

	@Override
	public boolean collidesWith(IShape pOtherShape) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isBlendingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setBlendingEnabled(boolean pBlendingEnabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSourceBlendFunction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDestinationBlendFunction() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBlendFunction(int pSourceBlendFunction,
			int pDestinationBlendFunction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public VertexBufferObjectManager getVertexBufferObjectManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IVertexBufferObject getVertexBufferObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShaderProgram getShaderProgram() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setShaderProgram(ShaderProgram pShaderProgram) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setVisible(boolean pVisible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isIgnoreUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIgnoreUpdate(boolean pIgnoreUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isChildrenVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setChildrenVisible(boolean pChildrenVisible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isChildrenIgnoreUpdate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setChildrenIgnoreUpdate(boolean pChildrenIgnoreUpdate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getZIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setZIndex(int pZIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasParent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IEntity getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParent(IEntity pEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getInitialX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getInitialY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setInitialPosition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(IEntity pOtherEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPosition(float pX, float pY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRotated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getRotation() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRotation(float pRotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getRotationCenterX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getRotationCenterY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRotationCenterX(float pRotationCenterX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotationCenterY(float pRotationCenterY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRotationCenter(float pRotationCenterX, float pRotationCenterY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isScaled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getScaleX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getScaleY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setScaleX(float pScaleX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScaleY(float pScaleY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(float pScale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScale(float pScaleX, float pScaleY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getScaleCenterX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getScaleCenterY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setScaleCenterX(float pScaleCenterX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScaleCenterY(float pScaleCenterY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScaleCenter(float pScaleCenterX, float pScaleCenterY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSkewed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getSkewX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getSkewY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSkewX(float pSkewX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSkewY(float pSkewY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSkew(float pSkew) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSkew(float pSkewX, float pSkewY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getSkewCenterX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getSkewCenterY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSkewCenterX(float pSkewCenterX) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSkewCenterY(float pSkewCenterY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSkewCenter(float pSkewCenterX, float pSkewCenterY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isRotatedOrScaledOrSkewed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getRed() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getGreen() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getBlue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getAlpha() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAlpha(float pAlpha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(Color pColor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(float pRed, float pGreen, float pBlue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setColor(float pRed, float pGreen, float pBlue, float pAlpha) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float[] getSceneCenterCoordinates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float[] convertLocalToSceneCoordinates(float pX, float pY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float[] convertLocalToSceneCoordinates(float pX, float pY,
			float[] pReuse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float[] convertLocalToSceneCoordinates(float[] pCoordinates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float[] convertLocalToSceneCoordinates(float[] pCoordinates,
			float[] pReuse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float[] convertSceneToLocalCoordinates(float pX, float pY) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float[] convertSceneToLocalCoordinates(float pX, float pY,
			float[] pReuse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float[] convertSceneToLocalCoordinates(float[] pCoordinates) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float[] convertSceneToLocalCoordinates(float[] pCoordinates,
			float[] pReuse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transformation getLocalToSceneTransformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transformation getSceneToLocalTransformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transformation getLocalToParentTransformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transformation getParentToLocalTransformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void onAttached() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDetached() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attachChild(IEntity pEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean attachChild(IEntity pEntity, int pIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IEntity getChild(int pIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getChild(IEntityMatcher pEntityMatcher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getFirstChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntity getLastChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getChildIndex(IEntity pEntity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean setChildIndex(IEntity pEntity, int pIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<IEntity> query(IEntityMatcher pEntityMatcher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <L extends List<IEntity>> L query(IEntityMatcher pEntityMatcher,
			L pResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends IEntity> ArrayList<S> queryForSubclass(
			IEntityMatcher pEntityMatcher) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <L extends List<S>, S extends IEntity> L queryForSubclass(
			IEntityMatcher pEntityMatcher, L pResult) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean swapChildren(int pIndexA, int pIndexB) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean swapChildren(IEntity pEntityA, IEntity pEntityB) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sortChildren() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortChildren(boolean pImmediate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sortChildren(Comparator<IEntity> pEntityComparator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean detachSelf() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean detachChild(IEntity pEntity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IEntity detachChild(IEntityMatcher pEntityMatcher) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean detachChildren(IEntityMatcher pEntityMatcher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void detachChildren() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void callOnChildren(IEntityParameterCallable pEntityParameterCallable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void callOnChildren(
			IEntityParameterCallable pEntityParameterCallable,
			IEntityMatcher pEntityMatcher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerUpdateHandler(IUpdateHandler pUpdateHandler) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean unregisterUpdateHandler(IUpdateHandler pUpdateHandler) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unregisterUpdateHandlers(
			IUpdateHandlerMatcher pUpdateHandlerMatcher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearUpdateHandlers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerEntityModifier(IEntityModifier pEntityModifier) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean unregisterEntityModifier(IEntityModifier pEntityModifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unregisterEntityModifiers(
			IEntityModifierMatcher pEntityModifierMatcher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearEntityModifiers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCullingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCullingEnabled(boolean pCullingEnabled) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCulled(Camera pCamera) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUserData(Object pUserData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getUserData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void toString(StringBuilder pStringBuilder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDraw(GLState pGLState, Camera pCamera) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdate(float pSecondsElapsed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDisposed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dispose() throws AlreadyDisposedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean contains(float pX, float pY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onAreaTouched(TouchEvent pSceneTouchEvent,
			float pTouchAreaLocalX, float pTouchAreaLocalY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public float getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getBaseWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getBaseHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getWidthScaled() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getHeightScaled() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setHeight(float pHeight) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWidth(float pWidth) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSize(float pWidth, float pHeight) {
		// TODO Auto-generated method stub
		
	}

}
