package org.andengine.extension.svg;

import java.util.Stack;

import org.andengine.entity.scene.background.AutoParallaxBackground;
import org.andengine.entity.scene.background.ParallaxBackground.ParallaxEntity;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.svg.adt.SVG;
import org.andengine.extension.svg.adt.SVGGradient;
import org.andengine.extension.svg.adt.SVGGradient.SVGGradientStop;
import org.andengine.extension.svg.adt.SVGGroup;
import org.andengine.extension.svg.adt.SVGProperties;
import org.andengine.extension.svg.adt.filter.SVGFilter;
import org.andengine.extension.svg.adt.filter.element.ISVGFilterElement;
import org.andengine.extension.svg.util.SAXHelper;
import org.andengine.extension.svg.util.SVGBaseBitmapTextureAtlasSource;
import org.andengine.extension.svg.util.SVGCircleParser;
import org.andengine.extension.svg.util.SVGEllipseParser;
import org.andengine.extension.svg.util.SVGLineParser;
import org.andengine.extension.svg.util.SVGPathParser;
import org.andengine.extension.svg.util.SVGPolygonParser;
import org.andengine.extension.svg.util.SVGPolylineParser;
import org.andengine.extension.svg.util.SVGRectParser;
import org.andengine.extension.svg.util.SVGTransformParser;
import org.andengine.extension.svg.util.constants.ISVGConstants;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.atlas.ITextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlas;
import org.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.atlas.source.ITextureAtlasSource;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.call.Callback;
import org.andengine.util.debug.Debug;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
public class SVGSceneHandler extends DefaultHandler implements ISVGConstants {
	// ===========================================================
	// Constants
	// ===========================================================
	private static final int BACKGROUND = 1;
	private static final int LEVEL 		= 2;
	private static final int OBJECTS	= 3;

	// ===========================================================
	// Fields
	// ===========================================================

	private Picture currentPucture;
	final VertexBufferObjectManager vertexBufferObjectManager;
	final TextureManager textureManager;
	private Context context;
	private AutoParallaxBackground autoParallaxBackground;
	private float speed;

	
	
	private Canvas mCanvas;
	private final SVGScene mSVGScene;

	private boolean mBoundsMode;
	private RectF mBounds;

	private final Stack<SVGGroup> mSVGGroupStack = new Stack<SVGGroup>();
	private final SVGPathParser mSVGPathParser = new SVGPathParser();

	private SVGGradient mCurrentSVGGradient;
	private SVGFilter mCurrentSVGFilter;

	private boolean mHidden;

	/** Multi purpose dummy rectangle. */
	private final RectF mRect = new RectF();
	private int currentElement;
	private int x;
	private int y;
	private int height;
	private int width;

	// ===========================================================
	// Constructors
	// ===========================================================

	public SVGSceneHandler(SVGScene scene) {
		this.mSVGScene = scene;
		vertexBufferObjectManager=scene.mVertexBufferObjectManager;
		textureManager=scene.mTextureManager;
		context=scene.mContext;
		autoParallaxBackground = new AutoParallaxBackground(0, 0, 0, 5);
		mSVGScene.setBackground(autoParallaxBackground);


		}


	// ===========================================================
	// Getter & Setter
	// ===========================================================
	public RectF getBounds() {
		return this.mBounds;
	}

	public RectF getComputedBounds() {
		return this.mSVGScene.getComputedBounds();
	}

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public void startElement(final String pNamespace, final String pLocalName, final String pQualifiedName, final Attributes pAttributes) throws SAXException {
		/* Ignore everything but rectangles in bounds mode. */
		if (this.mBoundsMode) {
			this.parseBounds(pLocalName, pAttributes);
			return;
		}
		if (pLocalName.equals(TAG_SVG)) {
			this.parseSVG(pAttributes);
		} else if(pLocalName.equals(TAG_DEFS)) {
			// Ignore
		} else if(pLocalName.equals(TAG_GROUP)) {
			this.parseGroup(pAttributes);
			
		} else if(pLocalName.equals(TAG_LINEARGRADIENT)) {
			this.parseLinearGradient(pAttributes);
		}  else if(pLocalName.equals(TAG_RADIALGRADIENT)) {
			this.parseRadialGradient(pAttributes);
		} else if(pLocalName.equals(TAG_STOP)) {
			this.parseGradientStop(pAttributes);
		} else if(pLocalName.equals(TAG_FILTER)) {
			this.parseFilter(pAttributes);
		} else if(pLocalName.equals(TAG_FILTER_ELEMENT_FEGAUSSIANBLUR)) {
			this.parseFilterElementGaussianBlur(pAttributes);
		} else if(!this.mHidden) {
			if(pLocalName.equals(TAG_RECTANGLE)) {
				this.parseRect(pAttributes);
			} else if(pLocalName.equals(TAG_LINE)) {
				this.parseLine(pAttributes);
			} else if(pLocalName.equals(TAG_CIRCLE)) {
				this.parseCircle(pAttributes);
			} else if(pLocalName.equals(TAG_ELLIPSE)) {
				this.parseEllipse(pAttributes);
			} else if(pLocalName.equals(TAG_POLYLINE)) {
				this.parsePolyline(pAttributes);
			} else if(pLocalName.equals(TAG_POLYGON)) {
				this.parsePolygon(pAttributes);
			} else if(pLocalName.equals(TAG_PATH)) {
				this.parsePath(pAttributes);
			} else {
				Debug.d("Unexpected SVG tag: '" + pLocalName + "'.");
			}
		} else {
			Debug.d("Unexpected SVG tag: '" + pLocalName + "'.");
		}
	}
	/*
	public void startElement(final String pUri, final String pLocalName, final String pQualifiedName, final Attributes pAttributes) throws SAXException {
		if(pLocalName.equals(TAG_RECT)){
			new RectNode(this.mSVGDoc).create(pAttributes, this.getCurrentTransform());
		}
		else if(pLocalName.equals(TAG_CIRCLE)){
			new CircleNode(this.mSVGDoc).create(pAttributes, this.getCurrentTransform());
		}
		else if(pLocalName.equals(TAG_LINE)){
			new LineNode(this.mSVGDoc).create(pAttributes, this.getCurrentTransform());
		}
		else if(pLocalName.equals(TAG_PATH)){
			new PathNode(this.mSVGDoc).create(pAttributes, this.getCurrentTransform());
		}
		else if(pLocalName.equals(TAG_POLYLINE)){
			new PolyLineNode(this.mSVGDoc).create(pAttributes, this.getCurrentTransform());
		}
		else if(pLocalName.equals(TAG_POLYGON)){
			new PolygonNode(this.mSVGDoc).create(pAttributes, this.getCurrentTransform());
		}
		else if(pLocalName.equals(TAG_ELLIPSE)){
			new EllipseNode(this.mSVGDoc).create(pAttributes, this.getCurrentTransform());
		}
		//--
		else if(pLocalName.equals(TAG_GROUP)){
			final TransformableNode group = new TransformableNode(this.mSVGDoc);
			group.create(pAttributes, this.getCurrentTransform());
			mTransformStack.add(group.getTransformation());
		}
]		else if(pLocalName.equals(TAG_STOP)){
		}
		else if(pLocalName.equals(TAG_DEFS)){
			final TransformableNode group = new TransformableNode(this.mSVGDoc);
			group.create(pAttributes, this.getCurrentTransform());
			mTransformStack.add(group.getTransformation());
		}
	}
*/
	@Override
	public void endElement(final String pNamespace, final String pLocalName, final String pQualifiedName) throws SAXException {
		if (pLocalName.equals(TAG_SVG)) {

		} else if (pLocalName.equals(TAG_GROUP)) {
			this.parseGroupEnd();
		}
	}

	// ===========================================================
	// Methods
	// ===========================================================

	private void parseSVG(final Attributes pAttributes) {
		 width = (int) Math.ceil(SAXHelper.getFloatAttribute(pAttributes, ATTRIBUTE_WIDTH, 0f));
		 height = (int) Math.ceil(SAXHelper.getFloatAttribute(pAttributes, ATTRIBUTE_HEIGHT, 0f));
	}

	private void parseBounds(final String pLocalName, final Attributes pAttributes) {
		if (pLocalName.equals(TAG_RECTANGLE)) {
			final float x = SAXHelper.getFloatAttribute(pAttributes, ATTRIBUTE_X, 0f);
			final float y = SAXHelper.getFloatAttribute(pAttributes, ATTRIBUTE_Y, 0f);
			final float width = SAXHelper.getFloatAttribute(pAttributes, ATTRIBUTE_WIDTH, 0f);
			final float height = SAXHelper.getFloatAttribute(pAttributes, ATTRIBUTE_HEIGHT, 0f);
			this.mBounds = new RectF(x, y, x + width, y + height);
		}
	}

	private void parseFilter(final Attributes pAttributes) {
		this.mCurrentSVGFilter = this.mSVGScene.parseFilter(pAttributes);
	}

	private void parseFilterElementGaussianBlur(final Attributes pAttributes) {
		final ISVGFilterElement svgFilterElement = this.mSVGScene.parseFilterElementGaussianBlur(pAttributes);
		this.mCurrentSVGFilter.addFilterElement(svgFilterElement);
	}

	private void parseLinearGradient(final Attributes pAttributes) {
		this.mCurrentSVGGradient = this.mSVGScene.parseGradient(pAttributes, true);
	}

	private void parseRadialGradient(final Attributes pAttributes) {
		this.mCurrentSVGGradient = this.mSVGScene.parseGradient(pAttributes, false);
	}

	private void parseGradientStop(final Attributes pAttributes) {
		final SVGGradientStop svgGradientStop = this.mSVGScene.parseGradientStop(this.getSVGPropertiesFromAttributes(pAttributes));
		this.mCurrentSVGGradient.addSVGGradientStop(svgGradientStop);
	}

	private void parseGroup(final Attributes pAttributes) {
		/* Check to see if this is the "bounds" layer. */
		if ("bounds".equals(SAXHelper.getStringAttribute(pAttributes, ATTRIBUTE_ID))) {
			this.mBoundsMode = true;
		}else if("AutoParallaxBackground".equals(SAXHelper.getStringAttribute(pAttributes, ATTRIBUTE_ID))){
			autoParallaxBackground.setParallaxValue( SAXHelper.getFloatAttribute(pAttributes, "data-speed"));
		}else if("Background".equals(SAXHelper.getStringAttribute(pAttributes, "class")) ){
			
			//----------------------------------
			currentElement=BACKGROUND;
			currentPucture=new Picture();
			this.mCanvas = currentPucture.beginRecording(width, height);
		}else if("Static".equals(SAXHelper.getStringAttribute(pAttributes, "class")) ){
			
			//----------------------------------
			currentElement=LEVEL;
			currentPucture=new Picture();
			this.mCanvas = currentPucture.beginRecording(width, height);
		}else if("Objects".equals(SAXHelper.getStringAttribute(pAttributes, "class")) ){
			
			//----------------------------------
			currentElement=OBJECTS;
			currentPucture=new Picture();
			this.mCanvas = currentPucture.beginRecording(width, height);
		}

		final SVGGroup parentSVGGroup = (this.mSVGGroupStack.size() > 0) ? this.mSVGGroupStack.peek() : null;
		final boolean hasTransform = this.pushTransform(pAttributes);

		this.mSVGGroupStack.push(new SVGGroup(parentSVGGroup, this.getSVGPropertiesFromAttributes(pAttributes, true), hasTransform));

		this.updateHidden();
	}

	private void parseGroupEnd() {
		if (this.mBoundsMode) {
			this.mBoundsMode = false;
		}
		if(currentElement == BACKGROUND){
			currentPucture.endRecording();
			int w =currentPucture.getWidth();
			int h=currentPucture.getHeight();
			BuildableBitmapTextureAtlas atlas = new BuildableBitmapTextureAtlas(textureManager, w,h);
			PictureTexture textureSource = new PictureTexture(currentPucture);
			final TextureRegion textureRegion = new TextureRegion(atlas, 0, 0, currentPucture.getWidth(), currentPucture.getHeight());
			atlas.addTextureAtlasSource(textureSource, new Callback() {
				@Override
				public void onCallback(Object pCallbackValue) {
					textureRegion.setTexturePosition(0,0);
				}
			});


			try {
				atlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				atlas.load();
			} catch (final TextureAtlasBuilderException e) {
				Debug.e(e);
			}
			ParallaxEntity layer = new ParallaxEntity(0.3f, new Sprite(x,y,w,h, textureRegion, vertexBufferObjectManager));
			autoParallaxBackground.attachParallaxEntity(layer);
			currentElement=0;
		}else if(currentElement == LEVEL){
			currentPucture.endRecording();
			SVG svg = new SVG(currentPucture, getBounds(),getComputedBounds());

			BuildableBitmapTextureAtlas atlas = new BuildableBitmapTextureAtlas(textureManager, width,height);

			IBitmapTextureAtlasSource textureSource = new SVGBaseBitmapTextureAtlasSource(svg,width, height);

			ITextureRegion back = BuildableTextureAtlasTextureRegionFactory.createFromSource(atlas, textureSource, false);
			try {
				atlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				atlas.load();
			} catch (final TextureAtlasBuilderException e) {
				Debug.e(e);
			}
			mSVGScene.attachChild(new Sprite(x,y,width,height, back,vertexBufferObjectManager));
			currentElement=0;
		}else if(currentElement == OBJECTS){
			currentPucture.endRecording();
			SVG svg = new SVG(currentPucture, getBounds(),getComputedBounds());

			BuildableBitmapTextureAtlas atlas = new BuildableBitmapTextureAtlas(textureManager, width,height);

			IBitmapTextureAtlasSource textureSource = new SVGBaseBitmapTextureAtlasSource(svg,width, height);

			ITextureRegion back = BuildableTextureAtlasTextureRegionFactory.createFromSource(atlas, textureSource, false);
			try {
				atlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
				atlas.load();
			} catch (final TextureAtlasBuilderException e) {
				Debug.e(e);
			}
			
			mSVGScene.attachChild(new Sprite(x,y,width,height, back, vertexBufferObjectManager));
			currentElement=0;
		}

		/* Pop group transform if there was one pushed. */
		if(this.mSVGGroupStack.pop().hasTransform()) {
			this.popTransform();
		}
		this.updateHidden();
	}

	private void updateHidden() {
		if(this.mSVGGroupStack.size() == 0) {
			this.mHidden = false;
		} else {
			this.mSVGGroupStack.peek().isHidden();
		}
	}

	private void parsePath(final Attributes pAttributes) {
		final SVGProperties svgProperties = this.getSVGPropertiesFromAttributes(pAttributes);
		final boolean pushed = this.pushTransform(pAttributes);
		this.mSVGPathParser.parse(svgProperties, this.mCanvas, this.mSVGScene);
		if(pushed) {
			this.popTransform();
		}
	}

	private void parsePolygon(final Attributes pAttributes) {
		final SVGProperties svgProperties = this.getSVGPropertiesFromAttributes(pAttributes);
		final boolean pushed = this.pushTransform(pAttributes);
		SVGPolygonParser.parse(svgProperties, this.mCanvas, this.mSVGScene);
		if(pushed) {
			this.popTransform();
		}
	}

	private void parsePolyline(final Attributes pAttributes) {
		final SVGProperties svgProperties = this.getSVGPropertiesFromAttributes(pAttributes);
		final boolean pushed = this.pushTransform(pAttributes);
		SVGPolylineParser.parse(svgProperties, this.mCanvas, this.mSVGScene);
		if(pushed) {
			this.popTransform();
		}
	}

	private void parseEllipse(final Attributes pAttributes) {
		final SVGProperties svgProperties = this.getSVGPropertiesFromAttributes(pAttributes);
		final boolean pushed = this.pushTransform(pAttributes);
		SVGEllipseParser.parse(svgProperties, this.mCanvas, this.mSVGScene, this.mRect);
		if(pushed) {
			this.popTransform();
		}
	}

	private void parseCircle(final Attributes pAttributes) {
		final SVGProperties svgProperties = this.getSVGPropertiesFromAttributes(pAttributes);
		final boolean pushed = this.pushTransform(pAttributes);
		SVGCircleParser.parse(svgProperties, this.mCanvas, this.mSVGScene);
		if(pushed) {
			this.popTransform();
		}
	}

	private void parseLine(final Attributes pAttributes) {
		final SVGProperties svgProperties = this.getSVGPropertiesFromAttributes(pAttributes);
		final boolean pushed = this.pushTransform(pAttributes);
		SVGLineParser.parse(svgProperties, this.mCanvas, this.mSVGScene);
		if(pushed) {
			this.popTransform();
		}
	}

	private void parseRect(final Attributes pAttributes) {
		final SVGProperties svgProperties = this.getSVGPropertiesFromAttributes(pAttributes);
		final boolean pushed = this.pushTransform(pAttributes);
		SVGRectParser.parse(svgProperties, this.mCanvas, this.mSVGScene, this.mRect);
		if(pushed) {
			this.popTransform();
		}
	}

	private SVGProperties getSVGPropertiesFromAttributes(final Attributes pAttributes) {
		return this.getSVGPropertiesFromAttributes(pAttributes, false);
	}

	private SVGProperties getSVGPropertiesFromAttributes(final Attributes pAttributes, final boolean pDeepCopy) {
		if(this.mSVGGroupStack.size() > 0) {
			return new SVGProperties(this.mSVGGroupStack.peek().getSVGProperties(), pAttributes, pDeepCopy);
		} else {
			return new SVGProperties(null, pAttributes, pDeepCopy);
		}
	}

	private boolean pushTransform(final Attributes pAttributes) {
		final String transform = SAXHelper.getStringAttribute(pAttributes, ATTRIBUTE_TRANSFORM);
		if(transform == null) {
			return false;
		} else {
			final Matrix matrix = SVGTransformParser.parseTransform(transform);
			this.mCanvas.save();
			this.mCanvas.concat(matrix);
			return true;
		}
	}

	private void popTransform() {
		this.mCanvas.restore();
	}

	public SVGScene getScene() {
		
		return mSVGScene;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}