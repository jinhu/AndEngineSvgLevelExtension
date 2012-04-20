package org.andengine.extension.svg.util;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */

public final class Translate {
	
	public static final void transformDoc(final TransformDoc pDoc, final float pTx, final float pTy) {
		//-- SVG transformation whole doc
		pDoc.setPosition(pDoc.getX() + pTx * pDoc.getScaleX(), pDoc.getY() + pTy * pDoc.getScaleY());
		//Log.e("translateDoc","x="+pDoc.getX()+" y="+pDoc.getY());
	}
}
