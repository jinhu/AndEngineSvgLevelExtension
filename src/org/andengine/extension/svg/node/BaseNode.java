package org.andengine.extension.svg.node;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import org.andengine.engine.handler.physics.PhysicsHandler;
import org.andengine.entity.shape.IAreaShape;
import org.andengine.entity.shape.Shape;
import org.andengine.entity.sprite.AnimatedSprite;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.sprite.TiledSprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.svg.SVGScene;
import org.andengine.extension.svg.SVGStyle;
import org.andengine.extension.svg.util.ParserUtil;
import org.andengine.extension.svg.util.constants.ISVGConstants;
import org.andengine.extension.svg.util.physic.ExtendedPhysicsFactory;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.vbo.VertexBufferObjectManager;
import org.andengine.util.SAXUtils;
import org.xml.sax.Attributes;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.MassData;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class BaseNode implements ISVGConstants{
	protected final SVGScene mSVGDoc;
	protected final VertexBufferObjectManager vbom;

	public BaseNode(final SVGScene pSVGDoc){
		this.mSVGDoc = pSVGDoc;
		this.vbom =pSVGDoc.mVertexBufferObjectManager;
	}
	
	//-- Sprite
	protected Shape createSprite(final Attributes pAttributes, final String pSource, final float pX, final float pY, final float pWidth, final float pHeight){
		return this.createSprite(pAttributes, pSource, pX, pY, pWidth, pHeight, 0, 1, 1);
	}
	protected Shape createSprite(final Attributes pAttributes, final String pSource, final float pX, final float pY, final float pWidth, final float pHeight, final float pRotation ){
		return this.createSprite(pAttributes, pSource, pX, pY, pWidth, pHeight, pRotation, 1, 1);
	}
	protected Shape createSprite(final Attributes pAttributes, final String pSource, final float pX, final float pY, final float pWidth, final float pHeight, final float pRotation, final float pScaleX, final float pScaleY ){
		
		//-- Shape
		
		final int texOptionIdex = SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_SPRITETEXTUREOPTION, 0);
		final org.andengine.extension.svg.util.TextureHolder texHolder = this.mSVGDoc.createTexture(pSource, texOptionIdex);
		final Shape shape;
		switch(SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_SPRITETYPE, 0)){
			case 1:
				//- TILED
				shape = new TiledSprite(
					pX, 
					pY, 
					pWidth, 
					pHeight,
					BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
						texHolder.getTexture(texOptionIdex),
						mSVGDoc.mContext.getAssets(), 
						pSource,
						0, 
						0, 
						SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_TILECOLS, 1), 
						SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_TILEROWS, 1)
					),
					vbom
				);
				((TiledSprite)shape).setCurrentTileIndex(SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_STARTTILE, 0));
				break;
			case 2:
				final int tilecols = SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_TILECOLS, 1);
				final int tilerows = SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_TILEROWS, 1);
				//- ANIMATED
				shape = new AnimatedSprite(
					pX, 
					pY, 
					pWidth, 
					pHeight,
					BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(
						texHolder.getTexture(texOptionIdex),
						mSVGDoc.mContext.getAssets(), 
						pSource, 
						0, 
						0, 
						tilecols, 
						tilerows
					),
				vbom);
				((AnimatedSprite)shape).setCurrentTileIndex(SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_STARTTILE, 0));
				if(SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_HAS_ANIMATION, false)){
					((AnimatedSprite)shape).animate(
						ParserUtil.createLongValueArray(SAXUtils.getAttributeOrThrow(pAttributes, TAG_ATTRIBUTE_ANIMATION_DURATION)), 
						SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_ANIMATION_STARTTILE, 0), 
						SAXUtils.getIntAttribute(pAttributes, TAG_ATTRIBUTE_ANIMATION_ENDTILE, tilecols*tilerows), 
						SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_ANIMATION_LOOP, true)
					);
				}
				break;
			default:
				//- Sprite
				shape = new Sprite(
					pX, 
					pY, 
					pWidth, 
					pHeight,
					BitmapTextureAtlasTextureRegionFactory.createFromAsset(
						texHolder.getTexture(texOptionIdex),
						mSVGDoc.mContext.getAssets(), 
						pSource, 
						0, 
						0
					),
					vbom
				);
				break;
		}
		
		final SVGStyle style = new SVGStyle(pAttributes.getValue(TAG_ATTRIBUTE_STYLE));
		shape.setAlpha(style.getFloatValue(TAG_ATTRIBUTE_STYLE_ALPHA, 1));
		
		shape.setRotation(pRotation);
		shape.setScale(pScaleX, pScaleY);
		
		return shape;
	}
	
	//-- Physic
	
	protected void registerPhysicsConnector(final Attributes pAttributes, final Shape pShape, final Body pBody){
		//TODO collision filters
		if(pBody.getType() != BodyType.StaticBody){
		
			//-- Mass Data
			final MassData mdata = new MassData();
			mdata.center.set(
				SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_MASSCENTERX, pBody.getLocalCenter().x),
				SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_MASSCENTERY, pBody.getLocalCenter().y)
			);
			mdata.mass = SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_MASS, pBody.getMass());
			mdata.I = SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_RATIONALINERTIA, pBody.getInertia());
			pBody.setMassData(mdata);
			
			//-- Physics Connector
			this.mSVGDoc.mPhysicsWorld.registerPhysicsConnector(
				new PhysicsConnector(
					(IAreaShape) pShape, 
					pBody, 
					SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_UPDATEPOSITION, true), 
					SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_UPDATEROTATION, true) 
				)
			);
		}
	}
	
	protected void createPhysicHandler(final Attributes pAttributes, final Shape pShape){
		final float linVelX = SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_VELOCITYX, 0);
		final float linVelY = SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_VELOCITYY, 0);
		final float accX = SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_ACCELERATIONX, 0);
		final float accY = SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_ACCELERATIONY, 0);
		final float angVel = SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_ANGULARVELOCITY, 0);
		if(linVelX!=0 || linVelY!=0 || angVel!=0 || accX!=0 || accY!=0){
			final PhysicsHandler physicsHandler = new PhysicsHandler(pShape);
			pShape.registerUpdateHandler(physicsHandler);
			physicsHandler.setVelocity(linVelX,linVelY);
			physicsHandler.setAngularVelocity(angVel);
			physicsHandler.setAcceleration(accX, accY);
		}
	}
	
	protected FixtureDef createFixtureDef(final Attributes pAttributes){
		return ExtendedPhysicsFactory.createFixtureDef(
			SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_DENSITY, 0), 
			SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_ELASTICITY, 0), 
			SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_FRICTION, 0),
			SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_ISSENSOR, false)
		);
	}
	
	protected void setBodyOptions(final Attributes pAttributes, final Body pBody){
		pBody.setAwake(SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_ISAWAKE, true));
		pBody.setSleepingAllowed(SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_SLEEPING_ALLOWED, true));
		pBody.setBullet(SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_ISBULLET, false));
		pBody.setActive(SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_ISACTIVE, true));
		//-- velocities
		pBody.setLinearVelocity(
			new Vector2(
				SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_VELOCITYX, 0),
				SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_VELOCITYY, 0)
			)
		);
		pBody.setAngularVelocity(SAXUtils.getFloatAttribute(pAttributes, TAG_ATTRIBUTE_ANGULARVELOCITY, 0));
		pBody.setFixedRotation(SAXUtils.getBooleanAttribute(pAttributes, TAG_ATTRIBUTE_FIXEDROTATION, false));
	}
}
