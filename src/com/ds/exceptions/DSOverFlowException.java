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

public class DSOverFlowException extends Exception {
	/**
	 * Exception to be thrown by a size-limited data
	 * structure when the operation exceeds the size
	 * of the actual data structure.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Throws an exception with custom message.
	 * 
	 * @param message string explaining why the error occurred.
	 */
	public DSOverFlowException(String message) {
		super(message);
	}
}
