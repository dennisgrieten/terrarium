package be.vdab.terrarium.util;

public class DierException extends Exception {

	private static final long serialVersionUID = 1L;

	public DierException() {
		super();
	}

	public DierException(String message) {
		super(message);
	}

	public DierException(String message, Throwable cause) {
		super(message, cause);
	}

	public DierException(Throwable cause) {
		super(cause);
	}
}
