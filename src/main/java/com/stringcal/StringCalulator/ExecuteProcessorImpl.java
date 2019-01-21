package com.stringcal.StringCalulator;

import java.util.Stack;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.stringcal.StringCalulator.exception.CanNotDivideByZero;
import com.stringcal.StringCalulator.strcalinterface.ExecuteProcessor;

public class ExecuteProcessorImpl implements ExecuteProcessor {

	@Override
	public int execute(String expression) {
		char[] expContent = expression.toCharArray();

		Stack<Integer> operands = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		for (int i = 0; i < expContent.length; i++) {
			if (expContent[i] == ' ')
				continue;
			if (expContent[i] >= '0' && expContent[i] <= '9') {
				StringBuffer sbuf = new StringBuffer();
				while (i < expContent.length && expContent[i] >= '0' && expContent[i] <= '9')
					sbuf.append(expContent[i++]);
				operands.push(Integer.parseInt(sbuf.toString()));
			} else if (expContent[i] == '(')
				operators.push(expContent[i]);
			else if (expContent[i] == ')') {
				while (operators.peek() != '(')
					operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
				operators.pop();
			} else if (expContent[i] == '+' || expContent[i] == '-' || expContent[i] == '*' || expContent[i] == '/'
					|| expContent[i] == '^') {
				while (!operators.empty() && hasPrecedence(expContent[i], operators.peek()))
					operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
				operators.push(expContent[i]);
			}
		}

		// System.err.println(operands);
		// System.err.println(operators);
		while (!operators.empty())
			operands.push(applyOperator(operators.pop(), operands.pop(), operands.pop()));
		return operands.pop();
	}

	// A utility method to apply an operator operator on operands 'a'and 'b'. Return
	// the result.
	public static int applyOperator(char op, int b, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new CanNotDivideByZero("Cannot divide by zero");
			return a / b;
		case '^':
			return a ^ b;
		}
		return 0;
	}

	// operator1,operator2
	// Returns true if operator2 has higher or same precedence as operator1
	public static boolean hasPrecedence(char operator1, char operator2) {
		if (operator2 == '(' || operator2 == ')')
			return false;
		if ((operator1 == '*' || operator1 == '/' || operator1 == '^') && (operator2 == '+' || operator2 == '-'))
			return false;
		else
			return true;
	}

	@Override
	public int scriptExecute(String expression) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		int result = 0;
		try {
			result = (int) engine.eval(expression);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
