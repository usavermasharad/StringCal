package com.stringcal.StringCalulator.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.stringcal.StringCalulator.ExpressionProcessorImpl;
import com.stringcal.StringCalulator.ExpressionScriptEngine;
import com.stringcal.StringCalulator.model.MathExpression;
import com.stringcal.StringCalulator.strcalinterface.ExpressionProcessor;
import com.stringcal.StringCalulator.strcalinterface.IStringCal;
import com.stringcal.StringCalulator.strcalinterface.Scripter;
/**
 * 
 * @author Sharad Kumar Verma
 *
 */
public class SpringCalulator implements IStringCal {
	ExpressionProcessor expressionProcessor = null;
	Scripter scripter = null;
	Map<String, Object> mapExp = new HashMap<>();

	public SpringCalulator(ExpressionProcessor expressionProcessor, Scripter scripter) {
		super();
		this.expressionProcessor = expressionProcessor;
		this.scripter = scripter;
	}

	public void processExpression(MathExpression mathExpression) {
		System.out.println("Valid Expression :");
		mathExpression.getExpression().stream().filter(e -> e != null)
				.map(e -> expressionProcessor.evaluateExpression(e)).filter(e -> e != null).forEach(System.out::println);
		
		List<String> myFinalList = mathExpression.getExpression().stream().filter(e -> e != null)
				.map(e -> expressionProcessor.evaluateExpression(e)).collect(Collectors.toList());
		myFinalList.stream().filter(e -> e != null).map(e -> scripter.scriptExecute(e)).forEach(System.out::println);

	}

	/**
	 * Main-starting point
	 * @param args
	 */
	public static void main(String[] args) {
		IStringCal obj = new SpringCalulator(new ExpressionProcessorImpl(), new ExpressionScriptEngine());

		List<String> expression = new ArrayList<>();
		expression.add("7+(6*5^2+3-4/2)");
		expression.add("7+(67(56*2))");
		expression.add("(8*+7");
		expression.add("(8*5/8)-(3/1)-5");
		expression.add("7+(67+(56*2))");

		MathExpression e = new MathExpression();
		e.setExpression(expression);
		obj.processExpression(e);

	}

}
