package org.andengine.extension.svg.exception;
/**
 * @author Eric Depta
 * @since 01:14:00 - 28.02.2011
 */
public class SVGLoadException extends SVGException{
	private static final long serialVersionUID = 7970858373596047934L;

	public SVGLoadException() {
		super();
	}

	public SVGLoadException(final String pDetailMessage, final Throwable pThrowable) {
		super(pDetailMessage, pThrowable);
	}

	public SVGLoadException(final String pDetailMessage) {
		super(pDetailMessage);
	}

	public SVGLoadException(final Throwable pThrowable) {
		super(pThrowable);
	}

}
