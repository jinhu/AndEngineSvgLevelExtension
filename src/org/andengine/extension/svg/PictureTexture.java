package org.andengine.extension.svg;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.source.BaseTextureAtlasSource;
import org.andengine.util.debug.Debug;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Picture;

public class PictureTexture extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource {
	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	public PictureTexture(int pTextureX, int pTextureY, int pTextureWidth,
			int pTextureHeight) {
		super(pTextureX, pTextureY, pTextureWidth, pTextureHeight);
		mPicture =null;
	}

	protected final Picture mPicture;

	// ===========================================================
	// Constructors
	// ===========================================================

	public PictureTexture(final Picture pPicture) {
		this(pPicture, 0, 0);
	}
	
	public PictureTexture(final Picture pPicture, final int pTextureX, final int pTextureY) {
		this(pPicture, pTextureX, pTextureY, pPicture.getWidth(), pPicture.getHeight());
	}

	public PictureTexture(final Picture pPicture, final int pTextureX, final int pTextureY, final float pScale) {
		this(pPicture, pTextureX, pTextureY, Math.round(pPicture.getWidth() * pScale), Math.round(pPicture.getHeight() * pScale));
	}

	public PictureTexture(final Picture pPicture, final int pTextureX, final int pTextureY, final int pTextureWidth, final int pTextureHeight) {
		super(pTextureX, pTextureY, pTextureWidth, pTextureHeight);

		this.mPicture = pPicture;
	}

	@Override
	public PictureTexture deepCopy(){
		
		return new PictureTexture(mPicture);
	}

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	@Override
	public Bitmap onLoadBitmap(final Config pBitmapConfig) {
		final Picture picture = this.mPicture;
		if(picture == null) {
			Debug.e("Failed loading Bitmap in " + this.getClass().getSimpleName() + ".");
			return null;
		}

		final Bitmap bitmap = Bitmap.createBitmap(this.mTextureWidth, this.mTextureHeight, pBitmapConfig);
		final Canvas canvas = new Canvas(bitmap);

		final float scaleX = (float)this.mTextureWidth / this.mPicture.getWidth();
		final float scaleY = (float)this.mTextureHeight / this.mPicture.getHeight();
		canvas.scale(scaleX, scaleY, 0, 0);

		picture.draw(canvas);

		return bitmap;
	}

	// ===========================================================
	// Methods
	// ===========================================================

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
