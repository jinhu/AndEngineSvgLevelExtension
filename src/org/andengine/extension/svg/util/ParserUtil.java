package org.andengine.extension.svg.util;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;

public final class ParserUtil {
	public static final long[] createLongValueArray(final String pAtr){
		final String[] strArr = pAtr.split(",");
		final long[] longArr = new long[strArr.length];
		for(int i=0;i<strArr.length;i++){
			longArr[i] = Long.parseLong(strArr[i], 10);
		}
		return longArr;
	}
	
	public static final Vector2 createVector(final String pAtr){
		if(pAtr.length()!=0){
			final String[] strArr = pAtr.split(",");
			if(strArr.length==2){
				return new Vector2(Float.parseFloat(strArr[0]), Float.parseFloat(strArr[1]));
			}else{
				final float vxy = Float.parseFloat(strArr[0]);
				return new Vector2(vxy, vxy);
			}
		}
		return new Vector2(0, 0);
	}
	
	public static final List<Vector2> createVectorList(final String pAtr){
		final List<Vector2> vertices = new ArrayList<Vector2>();
		if(pAtr.length()!=0){
			final String[] strArr = pAtr.split(" ");
			for(String str : strArr) {
				vertices.add(ParserUtil.createVector(str).cpy());
	        }
			return vertices;
		}
		return null;
	}
	
	public static float[] getColor(final String pColor){
		float[] color = new float[3];
		if(pColor!=null && !pColor.equals("none")){
			color[0] = SVGMathUtils.hex2float(pColor.substring(1,3));
			color[1] = SVGMathUtils.hex2float(pColor.substring(3,5));
			color[2] = SVGMathUtils.hex2float(pColor.substring(5,7));
		}
		return color;
	}
}
