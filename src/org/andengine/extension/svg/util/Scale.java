package org.andengine.extension.svg.util;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */

public final class Scale{
	public static final void transformDoc(final TransformDoc pDoc, final float pSx, final float pSy) {
		//-- SVG transformation whole doc
		pDoc.setScale(pDoc.getScaleX()*pSx, pDoc.getScaleY()*pSy);
		//Log.e("scaleDoc","x="+pDoc.getScaleX()+" y="+pDoc.getScaleY());
	}
}
