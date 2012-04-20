package org.andengine.extension.svg.exception;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
public abstract class SVGException extends Exception{
	private static final long serialVersionUID = -2078266564328184300L;

	public SVGException() {
		super();
	}

	public SVGException(final String pDetailMessage, final Throwable pThrowable) {
		super(pDetailMessage, pThrowable);
	}

	public SVGException(final String pDetailMessage) {
		super(pDetailMessage);
	}

	public SVGException(final Throwable pThrowable) {
		super(pThrowable);
	}

}
