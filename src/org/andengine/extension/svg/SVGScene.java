package org.andengine.extension.svg;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.entity.shape.RectangularShape;
import org.andengine.entity.shape.Shape;

import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.extension.svg.adt.SVGPaint;
import org.andengine.extension.svg.exception.SVGLoadException;
import org.andengine.extension.svg.exception.SVGParseException;
import org.andengine.extension.svg.util.TextureHolder;
import org.andengine.opengl.shader.ShaderProgram;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.vbo.IVertexBufferObject;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.badlogic.gdx.physics.box2d.Body;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.LinearGradient;
import android.graphics.Shader;




public class SVGScene extends SVGPaint{
	private final TreeMap<String,SVGElement> mElements = new TreeMap<String,SVGElement>();
	private final HashMap<String,TextureHolder> mTextures = new HashMap<String,TextureHolder>();
	private final HashMap<String,Shader> mShader = new HashMap<String,Shader>();

	private boolean debug = false;
	private boolean debugLine = false;
	private boolean debugFill = false;
	private float[] debugFillColor = {1,0,0};
	private float[] debugLineColor = {0.6f,0,0};
	private float debugFillAlpha = 0.3f;
	private float debugLineAlpha = 1f;
	private float debugLineWidth = 1f;
	
	private boolean mLineAntiAlias = false;
	
	public final PhysicsWorld mPhysicsWorld;
	public final Context mContext;
	public final TextureManager mTextureManager;
	public final VertexBufferObjectManager mVertexBufferObjectManager;
	
	public SVGScene(final Context pContext){
		this(pContext, null, null, null);
	}
	
	public SVGScene(final Context pContext, final PhysicsWorld pPhysicsWorld){
		this(pContext, pPhysicsWorld, null, null);
	}
	
	public SVGScene(final Context pContext, final TextureManager pTextureManager){
		this(pContext, null, pTextureManager,null);
	}
	
	public SVGScene(final Context pContext, final PhysicsWorld pPhysicsWorld, final TextureManager pTextureManager, VertexBufferObjectManager vertexBufferObjectManager){
		this.mPhysicsWorld = pPhysicsWorld;
		this.mTextureManager = pTextureManager;
		this.mContext = pContext;
		this.mVertexBufferObjectManager =vertexBufferObjectManager;
	}
	
	//-- Texture
	
	public TextureHolder createTexture(final String pSource, final int pTextureOptionIndex){
		TextureHolder texHolder;
		if(this.mTextures.containsKey(pSource)){
			texHolder = this.mTextures.get(pSource);
		}else{
			texHolder = new TextureHolder(mContext.getAssets(), pSource);
			//texHolder = new TextureHolder(null, pSource);
			this.mTextures.put(pSource, texHolder);
		}
		texHolder.addTexture(pTextureOptionIndex, this.mTextureManager);
		return texHolder;
	}
	
	//-- Elements
	public void addElement(String pName, final Shape pShape, final Body pBody){
		if(pShape!=null) {
			super.attachChild(pShape);
		}
		this.mElements.put(pName, new SVGElement(pShape,pBody));
	}
	
	public SVGElement getElement(String pName){
		if(this.mElements.containsKey(pName)){
			return this.mElements.get(pName);
		}else{
			return null;
		}
	}
	
	public TreeMap<String,SVGElement> getElements(){
		return this.mElements;
	}
	
	public void removeElements(){
		for ( Map.Entry<String, SVGElement> e : this.mElements.entrySet() ){
			final SVGElement ele = e.getValue();
	    	if(ele.hasBody()){
	    		this.removeBody(ele.getBody());
	    	}
	    	if(ele.hasShape()){
	    		this.removeShape(ele.getShape());
	    	}
		}
		this.mElements.clear();
	}
	
	public void removeBody(Body pBody){
    	for(int i = this.mPhysicsWorld.getPhysicsConnectorManager().size() - 1; i >= 0; i--){
    		final PhysicsConnector physicConnector = this.mPhysicsWorld.getPhysicsConnectorManager().get(i);
    		if(physicConnector.getBody() == pBody){
    			this.mPhysicsWorld.unregisterPhysicsConnector(physicConnector);
    		}
    	}
    	this.mPhysicsWorld.destroyBody(pBody);
	}
	
	public void removeShape(Shape pShape){
		pShape.detachChildren();		
		pShape.getParent().detachChild(pShape);
	}
	
	//-- Debug
	public void setDebug(final boolean pDebugFill, final boolean pDebugLine){
		if(pDebugFill || pDebugLine){
			this.debug = true;
		}else{
			this.debug = false;
		}
		this.debugLine = pDebugLine;
		this.debugFill = pDebugFill;
	}
	
	public void setDebugFill(final float[] pColor, final float pAlpha){
		this.debugFillAlpha = pAlpha;
		this.debugFillColor = pColor;
	}
	
	public void setDebugLine(final float[] pColor, final float pAlpha, final float pWidth){
		this.debugLineAlpha = pAlpha;
		this.debugLineColor = pColor;
		this.debugLineWidth = pWidth;
	}
	
	public boolean getDebug(){
		return this.debug;
	}
	
	public boolean getDebugFill(){
		return this.debugFill;
	}
	
	public boolean getDebugLine(){
		return this.debugLine;
	}
	
	public float[] getDebugFillColor(){
		return this.debugFillColor;
	}
	
	public float[] getDebugLineColor(){
		return this.debugLineColor;
	}
	
	public float getDebugFillAlpha(){
		return this.debugFillAlpha;
	}
	
	public float getDebugLineAlpha(){
		return this.debugLineAlpha;
	}
	

	public float getDebugLineWidth(){
		return this.debugLineWidth;
	}
	
	//misc
	public void setLineAntiAlias(boolean pLineAntiAlias){
		this.mLineAntiAlias = pLineAntiAlias;
	}
	
	public boolean getLineAntiAlias(){
		return this.mLineAntiAlias;
	}

	public void loadFromAssets(String pAssetPath) throws Exception{
		final InputStream inputStream = mContext.getAssets().open(pAssetPath);
		final SAXParserFactory spf = SAXParserFactory.newInstance();
		final SAXParser sp = spf.newSAXParser();
		final XMLReader xr = sp.getXMLReader();
		final SVGSceneHandler svgHandler = new SVGSceneHandler(this);
		xr.setContentHandler(svgHandler);
		xr.parse(new InputSource(inputStream));
		Rectangle r = new Rectangle(100f,100f,100f,100f, mVertexBufferObjectManager);
		attachChild(r);
		r.setColor(0.5f,0f,0f,0.5f);
		}
	public void addShader(String name, LinearGradient value) {
		mShader.put(name, value);
	}
}
