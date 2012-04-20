package org.andengine.extension.svg.util;

import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.AssetBitmapTextureAtlasSource;
import org.andengine.util.math.MathUtils;

import android.content.Context;
import android.content.res.AssetManager;


public class TextureHolder {
	private AssetBitmapTextureAtlasSource mAssetTextureSource;
	private BitmapTextureAtlas[] mTextures = new BitmapTextureAtlas[9];
	
	public TextureHolder(final AssetManager pContext, final String pSource){
		this.mAssetTextureSource =  AssetBitmapTextureAtlasSource.create(pContext, pSource);
	}
	
	public void addTexture(final int pTextureOptionIndex, final TextureManager pTextureManager){
		if(this.mTextures[pTextureOptionIndex]==null){
			mTextures[pTextureOptionIndex] = new BitmapTextureAtlas(
					pTextureManager, 
					MathUtils.nextPowerOfTwo(this.mAssetTextureSource.getTextureWidth()), 
					MathUtils.nextPowerOfTwo(this.mAssetTextureSource.getTextureHeight()),
					this.getTextureOption(pTextureOptionIndex)); 
			pTextureManager.loadTexture(mTextures[pTextureOptionIndex]);
		}
	}
	
	public BitmapTextureAtlas getTexture(final int pTextureOptionIndex){
		return this.mTextures[pTextureOptionIndex];
	}
	
	public TextureOptions getTextureOption(final int pIndex) {
		switch(pIndex){
			case 1:
				return TextureOptions.NEAREST;
			case 2:
				return TextureOptions.BILINEAR;
			/* not supportet anymore
			case 3:
				return TextureOptions.REPEATING;
			*/
			case 4:
				return TextureOptions.REPEATING_BILINEAR;
			case 5:
				return TextureOptions.NEAREST_PREMULTIPLYALPHA;
			case 6:
				return TextureOptions.BILINEAR_PREMULTIPLYALPHA;
			/* not supportet anymore	
			case 7:
				return TextureOptions.REPEATING_PREMULTIPLYALPHA;
			*/
			case 8:
				return TextureOptions.REPEATING_BILINEAR_PREMULTIPLYALPHA;
			default:
				return TextureOptions.DEFAULT;
		}
	} 
	
	public AssetBitmapTextureAtlasSource getAssetTextureSource(){
		return this.mAssetTextureSource;
	}


}
