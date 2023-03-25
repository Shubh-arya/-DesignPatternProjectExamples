package data_strucuture_and_algorithms.stack;

public class StackUnderflowException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	StackUnderflowException() {
	}

	StackUnderflowException(String message) {
		super(message);
	}

}
