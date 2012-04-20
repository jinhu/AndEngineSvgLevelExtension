package org.andengine.extension.svg.util.constants;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
public interface SVGConstants {
	public static final String TAG_GROUP = "g";
	public static final String TAG_DEFS = "defs";
	
	public static final String TAG_RECT = "rect";
	public static final String TAG_PATH = "path";
	public static final String TAG_CIRCLE = "circle";
	public static final String TAG_LINE = "line";
	public static final String TAG_POLYLINE = "polyline";
	public static final String TAG_POLYGON = "polygon";
	public static final String TAG_ELLIPSE = "ellipse";
	public static final String TAG_RADIAL_GRADIENT = "radialGradient";
	public static final String TAG_LINEAR_GRADIENT = "linearGradient";
	public static final String TAG_STOP = "stop";
	 
	public static final String TAG_ATTRIBUTE_ID = "id";
	public static final String TAG_ATTRIBUTE_TRANSFORM = "transform";
	public static final String TAG_ATTRIBUTE_STYLE = "style";
	public static final String TAG_ATTRIBUTE_STYLE_ALPHA = "opacity";
	public static final String TAG_ATTRIBUTE_STYLE_FILLCOLOR = "fill";
	public static final String TAG_ATTRIBUTE_STYLE_FILLALPHA = "fill-opacity";
	public static final String TAG_ATTRIBUTE_STYLE_LINECOLOR = "stroke";
	public static final String TAG_ATTRIBUTE_STYLE_LINEALPHA = "stroke-opacity";
	public static final String TAG_ATTRIBUTE_STYLE_LINEWIDTH = "stroke-width";
		
	public static final String TAG_ATTRIBUTE_X = "x";
	public static final String TAG_ATTRIBUTE_Y = "y";
	public static final String TAG_ATTRIBUTE_X1 = "x1";
	public static final String TAG_ATTRIBUTE_Y1 = "y1";
	public static final String TAG_ATTRIBUTE_X2 = "x2";
	public static final String TAG_ATTRIBUTE_Y2 = "y2";
	public static final String TAG_ATTRIBUTE_WIDTH = "width";
	public static final String TAG_ATTRIBUTE_HEIGHT = "height";
	public static final String TAG_ATTRIBUTE_CENTER_X = "cx";
	public static final String TAG_ATTRIBUTE_CENTER_Y = "cy";
	public static final String TAG_ATTRIBUTE_RADIUS = "r";
	public static final String TAG_ATTRIBUTE_RADIUS_X = "rx";
	public static final String TAG_ATTRIBUTE_RADIUS_Y = "ry";
	public static final String TAG_ATTRIBUTE_PATH = "d";
	public static final String TAG_ATTRIBUTE_POINTS = "points";
	
	/*
	 * AndEngine specific
	 */
	
	//-- Sprite
	public static final String TAG_ATTRIBUTE_HASSHAPE 				= "andengine-hasshape";
	public static final String TAG_ATTRIBUTE_SPRITESRC 				= "andengine-spritesrc";
	public static final String TAG_ATTRIBUTE_SPRITETYPE 			= "andengine-spritetype";
	public static final String TAG_ATTRIBUTE_SPRITETEXTUREOPTION 	= "andengine-spritetextureoption";
	public static final String TAG_ATTRIBUTE_TILECOLS 				= "andengine-tilecols";
	public static final String TAG_ATTRIBUTE_TILEROWS 				= "andengine-tilerows";
	public static final String TAG_ATTRIBUTE_STARTTILE 				= "andengine-starttile";
	public static final String TAG_ATTRIBUTE_HAS_ANIMATION 			= "andengine-has-animation";
	public static final String TAG_ATTRIBUTE_ANIMATION_STARTTILE 	= "andengine-animation-starttile";
	public static final String TAG_ATTRIBUTE_ANIMATION_ENDTILE 		= "andengine-animation-endtile";
	public static final String TAG_ATTRIBUTE_ANIMATION_LOOP 		= "andengine-animation-loop";
	public static final String TAG_ATTRIBUTE_ANIMATION_DURATION 	= "andengine-animation-duration";
	public static final String TAG_ATTRIBUTE_DRAWPRIMITIVE 			= "andengine-drawprimitives";
	public static final String TAG_ATTRIBUTE_ACCELERATIONX 			= "andengine-accelerationx";
	public static final String TAG_ATTRIBUTE_ACCELERATIONY 			= "andengine-accelerationy";
	
	//-- Physic
	public static final String TAG_ATTRIBUTE_HASPHYSIC 				= "andengine-physic";
	public static final String TAG_ATTRIBUTE_DENSITY 				= "andengine-density";
	public static final String TAG_ATTRIBUTE_ELASTICITY 			= "andengine-elasticity";
	public static final String TAG_ATTRIBUTE_FRICTION 				= "andengine-friction";
	public static final String TAG_ATTRIBUTE_ISSENSOR				= "andengine-issensor";
	public static final String TAG_ATTRIBUTE_BODYTYPE 				= "andengine-bodytype";
	public static final String TAG_ATTRIBUTE_ISAWAKE 				= "andengine-isawake";
	public static final String TAG_ATTRIBUTE_SLEEPING_ALLOWED 		= "andengine-issleepingallowed";
	public static final String TAG_ATTRIBUTE_ISBULLET 				= "andengine-isbullet";
	public static final String TAG_ATTRIBUTE_ISACTIVE 				= "andengine-isactive";
	public static final String TAG_ATTRIBUTE_FIXEDROTATION 			= "andengine-fixedrotation";
	
	public static final String TAG_ATTRIBUTE_MASS 					= "andengine-mass";
	public static final String TAG_ATTRIBUTE_MASSCENTERX 			= "andengine-masscenterx";
	public static final String TAG_ATTRIBUTE_MASSCENTERY 			= "andengine-masscentery";
	public static final String TAG_ATTRIBUTE_RATIONALINERTIA 		= "andengine-rotationalinertia";
	
	public static final String TAG_ATTRIBUTE_UPDATEPOSITION 		="andengine-updateposition";
	public static final String TAG_ATTRIBUTE_UPDATEROTATION 		="andengine-updaterotation";
	
	//-- Physic and Sprite
	public static final String TAG_ATTRIBUTE_CURVE_SEGMENTS 		= "andengine-curvesegments";
	public static final String TAG_ATTRIBUTE_VELOCITYX 				= "andengine-velocityx";
	public static final String TAG_ATTRIBUTE_VELOCITYY 				= "andengine-velocityy";
	public static final String TAG_ATTRIBUTE_ANGULARVELOCITY 		= "andengine-angularvelocity";
}