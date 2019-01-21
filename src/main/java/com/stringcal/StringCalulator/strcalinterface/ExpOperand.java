package com.stringcal.StringCalulator.strcalinterface;

/**
 * 
 * @author Sharad Kumar Verma
 *
 */
public interface ExpOperand {
	public static boolean isDigit(char input) {
		if (input == '1' || input == '2' || input == '3' || input == '4' || input == '5' || input == '6' || input == '7'
				|| input == '8' || input == '9' || input == '0')
			return true;

		return false;
	}
}
