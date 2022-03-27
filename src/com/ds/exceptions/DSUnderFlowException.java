/**
 * This Java class is a part of com.ds, a package
 * containing the basic data structure code.
 */
package com.ds.exceptions;

/**
 * One of the Custom Exception class meant to be used by any
 * Data Structure.
 * 
 * @author Himanshu Bisht
 *
 */
public class DSUnderFlowException extends Exception {
	/**
	 * Exception to be thrown by a size-limited data
	 * structure when the operation could not be
	 * performed due to the DS being empty.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Throws an exception with custom message.
	 * 
	 * @param message string explaining why the error occurred.
	 */
	public DSUnderFlowException(String message) {
		super(message);
	}
}
