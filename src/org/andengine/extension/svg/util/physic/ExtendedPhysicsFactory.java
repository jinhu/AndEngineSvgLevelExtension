package org.andengine.extension.svg.util.physic;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import static org.andengine.extension.physics.box2d.util.constants.PhysicsConstants.PIXEL_TO_METER_RATIO_DEFAULT;

import org.andengine.entity.shape.IShape;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.util.Constants;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;



public final class ExtendedPhysicsFactory extends PhysicsFactory {
	
	public static final Body createLinesBody(final PhysicsWorld pPhysicsWorld, final IShape pIShape, final Vector2[] pVertices, final BodyType pBodyType, final FixtureDef pFixtureDef) {
		return ExtendedPhysicsFactory.createLinesBody(pPhysicsWorld, pIShape, pVertices, pBodyType, pFixtureDef, PIXEL_TO_METER_RATIO_DEFAULT);
	}
	public static final Body createLinesBody(final PhysicsWorld pPhysicsWorld, final IShape pIShape, final Vector2[] pVertices, final BodyType pBodyType, final FixtureDef pFixtureDef, final float pPixelToMeterRatio) {
		final BodyDef boxBodyDef = new BodyDef();
		boxBodyDef.type = pBodyType;

		final float[] sceneCenterCoordinates = pIShape.getSceneCenterCoordinates();
		boxBodyDef.position.x = sceneCenterCoordinates[Constants.VERTEX_INDEX_X] / pPixelToMeterRatio;
		boxBodyDef.position.y = sceneCenterCoordinates[Constants.VERTEX_INDEX_Y] / pPixelToMeterRatio;

		final Body boxBody = pPhysicsWorld.createBody(boxBodyDef);

		final PolygonShape linesPoly = new PolygonShape();
		
		for(int i=1;i<pVertices.length;i++){
			linesPoly.setAsEdge(pVertices[i-1],pVertices[i]);
			pFixtureDef.shape = linesPoly;
			boxBody.createFixture(pFixtureDef);
		}

		linesPoly.dispose();

		return boxBody;
	}
}
