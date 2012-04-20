package org.andengine.extension.svg;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
import java.util.HashMap;

public class SVGStyle extends HashMap<String, String>{
	private static final long serialVersionUID = -4017033695786407418L;

	public SVGStyle(String pSytle){
		final String[] stylesArr = pSytle.split(";");
		for(String str : stylesArr){
			final String[] valueArr = str.split(":");
			super.put(valueArr[0], valueArr[1]);
		}
	}
	
	public String getValue(final String pKey){
		if(super.containsKey(pKey)){
			return super.get(pKey);
		}else{
			return null;
		}
	}
	
	public String getShaderName(final String pKey,final String pDefaultValue){
		final String value = this.getValue(pKey);
		return (value != null) ? value : pDefaultValue;
	}
	public String getStringValue(final String pKey,final String pDefaultValue){
		final String value = this.getValue(pKey);
		return (value != null) ? value : pDefaultValue;
	}
	
	public int getIntegerValue(final String pKey,final int pDefaultValue){
		final String value = this.getValue(pKey);
		return (value != null) ? Integer.parseInt(value) : pDefaultValue;
	}
	
	public boolean getBooleanValue(final String pKey,final boolean pDefaultValue){
		final String value = this.getValue(pKey);
		return (value != null) ? Boolean.parseBoolean(value) : pDefaultValue;
	}
	
	public float getFloatValue(final String pKey,final float pDefaultValue){
		final String value = this.getValue(pKey);
		return (value != null) ? Float.parseFloat(value) : pDefaultValue;
	}
	public float getFloatValuePx(final String pKey,final float pDefaultValue){
		final String value = this.getValue(pKey);
		if(value != null){
			if(value.contains("px")){
				return Float.parseFloat(value.substring(0,value.length()-2));
			}else{
				return Float.parseFloat(value);
			}
		}else{
			return pDefaultValue;
		}
	}
	
}

