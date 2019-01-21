package com.stringcal.StringCalulator;

import com.stringcal.StringCalulator.exception.InvalidExpressionException;
import com.stringcal.StringCalulator.strcalinterface.ExpOperator;
import com.stringcal.StringCalulator.strcalinterface.ExpressionProcessor;

public class ExpressionProcessorImpl implements ExpressionProcessor {

	/**
	 * Evaluate Expression
	 */
	@Override
	public String evaluateExpression(String expression) {
		try {
			
			if (verifyFirstOperator(expression) == ConstantOperator.ZERO)
				throw new InvalidExpressionException(
						" Expression First operator: " + ConstantOperator.EXCEPTION_CHAR_CLOSE + " so which is Invali");
			if (veriLastOperator(expression) == ConstantOperator.ZERO)
				throw new InvalidExpressionException(" Expression has Last operator: "
						+ ConstantOperator.EXCEPTION_CHAR_OPEN + " so which is Invalid ");

			if(isTwoOpContinueInExp(expression)==ConstantOperator.ZERO)
				throw new InvalidExpressionException(
						" There is two operator continue in expression: ");
			if(isBracketDigitBracket(expression)==ConstantOperator.ZERO)
				throw new InvalidExpressionException(
						" There is bracket digit after bracket operator continue in expression: ");
			
			
			if (verifyExpressionWithStart(expression) == ConstantOperator.ZERO)
				throw new InvalidExpressionException(
						" In start there is operator in expression therefore this is Invalid Case ");
			if (verifyExpressionWithEnd(expression) == ConstantOperator.ZERO)
				throw new InvalidExpressionException(
						" In End there is operator in expression therefor which is Invalid Case ");

		} catch (InvalidExpressionException e) {
			//System.out.println("Error:InvalidExpressionException ");
			return null;
		}

		return expression;
	}

	private static int isBracketDigitBracket(String expression) {
		char[] verifyOperators = expression.toCharArray();
		int differCharCount = 0;
		boolean findBracket = false;
		int bracketCount=0;
		for (int i = 0; i < verifyOperators.length; i++) {
			if (verifyOperators[i] == '(') { 
				findBracket=true;
				bracketCount++;
				if(bracketCount==2) {
					//System.out.println("0");
					return 0;
				}
				differCharCount =0; //reset differ count;
				continue;
			}else if(ExpOperator.isOperator(verifyOperators[i])) {
				differCharCount++;
			}
			if(findBracket && differCharCount >0) {
				bracketCount=0;
				differCharCount=0;
				findBracket =false;
			
				
			}
		}
		return 1;
	}
	
	private int isTwoOpContinueInExp(String expression) {
		int countinueOperator = 0;
		char[] verifyOperators = expression.toCharArray();
		for (int i = 0; i < verifyOperators.length; i++) {
			if (ExpOperator.isOperator(verifyOperators[i])) {
				countinueOperator++;
				if (countinueOperator == 2) {
					return 0;
					//System.out.println("Invalid");
				}
				continue;
			}else {
					countinueOperator=0;
			}
				
		}
		//System.out.println("valid");
		return 1;


	}

	/**
	 * 
	 * @param expression
	 * @return
	 */
	private int verifyFirstOperator(String expression) {
		char firstChar = expression.charAt(0);

		if (ConstantOperator.EXCEPTION_CHAR_CLOSE == firstChar) {
			return 0;// Invalid Expression
		}
		return 1;
	}

	/**
	 * 
	 * @param expression
	 * @return
	 */
	private int veriLastOperator(String expression) {
		char lastChar = expression.charAt(expression.length() - 1);

		if (ConstantOperator.EXCEPTION_CHAR_OPEN == lastChar) {
			return 0;// Invalid Expression
		}
		return 1;
	}

	private int verifyExpressionWithStart(String expression) {

		if (ExpOperator.isOperator(expression.charAt(0))) {
			return 0; // Invalid Expression
		}
		return 1;

	}

	private int verifyExpressionWithEnd(String expression) {
		if (ExpOperator.isOperator(expression.charAt(expression.length() - 1))) {
			return 0; // Invalid Expression
		}
		return 1; // valid Expression

	}
}
