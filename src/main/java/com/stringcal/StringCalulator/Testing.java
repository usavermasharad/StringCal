package com.stringcal.StringCalulator;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import com.stringcal.StringCalulator.exception.InvalidExpressionException;
import com.stringcal.StringCalulator.exception.InvalidOperatorException;
import com.stringcal.StringCalulator.strcalinterface.ExpOperator;

public class Testing {

	// 7+(6*5^2+3-4/2)
	// 7+(67(56*2))
	// 8*+7
	// (8*5/8)-(3/1)-5

	// if Zero then Inva

	private static void verifyTwoOperatorContinue(String expression) {
		int countinueOperator = 0;
		char[] verifyOperators = expression.toCharArray();
		for (int i = 0; i < verifyOperators.length; i++) {
			if (ExpOperator.isOperator(verifyOperators[i])) {
				countinueOperator++;
				if (countinueOperator == 2) {
					// return 0;
					System.out.println("Invalid");
				}
				continue;
			} else {
				countinueOperator = 0;
			}

		}
		System.out.println("valid");
		// return 1;

	}

	// 7+(67+((56*2))
	private static void isBracketDigitBracket(String expression) {
		char[] verifyOperators = expression.toCharArray();
		int differCharCount = 0;
		boolean findBracket = false;
		int digitCount=0;
		int bracketCount=0;
		for (int i = 0; i < verifyOperators.length; i++) {
			if (verifyOperators[i] == '(') { 
				findBracket=true;
				bracketCount++;
				if(bracketCount==2) {
					System.out.println("0");
					//return 0;
				}
				digitCount=0;//reset digit 
				differCharCount =0; //reset differ count;
				continue;
			}else if(verifyOperators[i] >='0' && verifyOperators[i] <='9') {
				digitCount++;
			}else if(ExpOperator.isOperator(verifyOperators[i])) {
				differCharCount++;
			}
			if(findBracket && differCharCount >0) {
			//	System.out.println("valid"); //return 1;
				bracketCount=0;
				digitCount=0;
				differCharCount=0;
				findBracket =false;
				
			}
		}

	}
	public static void main(String[] args) {

		isBracketDigitBracket("7+(67(56*2))");
		isBracketDigitBracket("7++(67+(56*2))");
	}

}
