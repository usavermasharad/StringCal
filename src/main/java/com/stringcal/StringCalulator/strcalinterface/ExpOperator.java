package com.stringcal.StringCalulator.strcalinterface;

/**
 * 
 * @author Sharad Kumar Verma
 *
 */
public interface ExpOperator {
	public static boolean isOperator(char input) {
		if (input == '+' || input == '-' || input == '*' || input == '/'|| input == '^')
			return true;

		return false;
	}

	public static boolean exculdeOp(char input) {
		if (input == '(' || input == ')')
			return true;

		return false;
	}
}
