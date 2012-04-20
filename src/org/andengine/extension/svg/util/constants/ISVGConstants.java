package org.andengine.extension.svg.util.constants;

/**
 * (c) 2010 Nicolas Gramlich 
 * (c) 2011 Zynga Inc.
 * 
 * @author Nicolas Gramlich
 * @since 13:44:22 - 26.05.2011
 */
public interface ISVGConstants {
	// ===========================================================
	// Final Fields
	// ===========================================================

	public static final String UNIT_PX = "px";

	public static final String VALUE_NONE = "none";

	public static final String TAG_SVG = "svg";
	public static final String TAG_DEFS = "defs";
	public static final String TAG_LINEARGRADIENT = "linearGradient";
	public static final String TAG_RADIALGRADIENT = "radialGradient";
	public static final String TAG_FILTER = "filter";
	public static final String TAG_FILTER_ELEMENT_FEGAUSSIANBLUR = "feGaussianBlur";
	public static final String TAG_STOP = "stop";

	public static final String TAG_GROUP = "g";

	public static final String TAG_CIRCLE = "circle";
	public static final String TAG_ELLIPSE = "ellipse";
	public static final String TAG_LINE = "line";
	public static final String TAG_PATH = "path";
	public static final String TAG_POLYGON = "polygon";
	public static final String TAG_POLYLINE = "polyline";
	public static final String TAG_RECTANGLE = "rect";

	public static final String ATTRIBUTE_ID = "id";
	public static final String ATTRIBUTE_HREF = "href";
	public static final String ATTRIBUTE_STYLE = "style";
	public static final String ATTRIBUTE_DISPLAY = "display";

	public static final String ATTRIBUTE_X = "x";
	public static final String ATTRIBUTE_Y = "y";
	public static final String ATTRIBUTE_X1 = "x1";
	public static final String ATTRIBUTE_Y1 = "y1";
	public static final String ATTRIBUTE_X2 = "x2";
	public static final String ATTRIBUTE_Y2 = "y2";
	public static final String ATTRIBUTE_WIDTH = "width";
	public static final String ATTRIBUTE_HEIGHT = "height";
	public static final String ATTRIBUTE_CENTER_X = "cx";
	public static final String ATTRIBUTE_CENTER_Y = "cy";
	public static final String ATTRIBUTE_RADIUS = "r";
	public static final String ATTRIBUTE_RADIUS_X = "rx";
	public static final String ATTRIBUTE_RADIUS_Y = "ry";
	public static final String ATTRIBUTE_TRANSFORM = "transform";
	public static final String ATTRIBUTE_TRANSFORM_VALUE_ROTATE = "rotate";
	public static final String ATTRIBUTE_TRANSFORM_VALUE_SKEW_Y = "skewY";
	public static final String ATTRIBUTE_TRANSFORM_VALUE_SKEW_X = "skewX";
	public static final String ATTRIBUTE_TRANSFORM_VALUE_SCALE = "scale";
	public static final String ATTRIBUTE_TRANSFORM_VALUE_TRANSLATE = "translate";
	public static final String ATTRIBUTE_TRANSFORM_VALUE_MATRIX = "matrix";
	public static final String ATTRIBUTE_POINTS = "points";
	public static final String ATTRIBUTE_PATHDATA = "d";
	public static final String ATTRIBUTE_FILLRULE = "fill-rule";
	public static final String ATTRIBUTE_FILLRULE_VALUE_EVENODD = "evenodd";
	public static final String ATTRIBUTE_FILTER_ELEMENT_FEGAUSSIANBLUR_STANDARDDEVIATION = "stdDeviation";
	public static final String ATTRIBUTE_SPREADMETHOD = "speardMethod";
	public static final String ATTRIBUTE_SPREADMETHOD_VALUE_PAD = "pad";
	public static final String ATTRIBUTE_SPREADMETHOD_VALUE_REFLECT = "reflect";
	public static final String ATTRIBUTE_SPREADMETHOD_VALUE_REPEAT = "repeat";

	public static final String ATTRIBUTE_GRADIENT_TRANSFORM = "gradientTransform";
	public static final String ATTRIBUTE_STOP_OPACITY = "stop-opacity";
	public static final String ATTRIBUTE_STOP_COLOR = "stop-color";
	public static final String ATTRIBUTE_OFFSET = "offset";

	public static final String ATTRIBUTE_OPACITY = "opacity";
	public static final String ATTRIBUTE_FILTER = "filter";
	public static final String ATTRIBUTE_FILL = "fill";
	public static final String ATTRIBUTE_FILL_OPACITY = "fill-opacity";
	public static final String ATTRIBUTE_STROKE = "stroke";
	public static final String ATTRIBUTE_STROKE_OPACITY = "stroke-opacity";
	public static final String ATTRIBUTE_STROKE_WIDTH = "stroke-width";
	public static final String ATTRIBUTE_STROKE_LINECAP_VALUE_BUTT = "butt";
	public static final String ATTRIBUTE_STROKE_LINECAP_VALUE_SQUARE = "square";
	public static final String ATTRIBUTE_STROKE_LINECAP_VALUE_ROUND = "round";
	public static final String ATTRIBUTE_STROKE_LINEJOIN_VALUE_BEVEL = "bevel";
	public static final String ATTRIBUTE_STROKE_LINEJOIN_VALUE_ROUND = ATTRIBUTE_STROKE_LINECAP_VALUE_ROUND;
	public static final String ATTRIBUTE_STROKE_LINEJOIN_VALUE_MITER = "miter";
	public static final String ATTRIBUTE_STROKE_LINEJOIN_VALUE_ = "stroke-linejoin";
	public static final String ATTRIBUTE_STROKE_LINECAP = "stroke-linecap";


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
	
	
	
	
	// ===========================================================
	// Methods
	// ===========================================================
}
