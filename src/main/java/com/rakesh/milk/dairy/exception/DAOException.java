package com.rakesh.milk.dairy.exception;

/**
 * 
 * @author rakesh.kumar
 *
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 8092001203754678496L;

	public DAOException() {
		super();
	}

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable t) {
		super(t);
	}

	public DAOException(String s, Throwable t) {
		super(s, t);
	}

}
