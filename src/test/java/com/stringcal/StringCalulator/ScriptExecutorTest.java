package com.stringcal.StringCalulator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class ScriptExecutorTest extends BaseTest {

	@Test
	public void testObjectCreation() {
		assert !Objects.isNull(mathExpression);
		assert !Objects.isNull(expressionProcessor);
		assert !Objects.isNull(scripter);
		assert !Objects.isNull(mapExp);
	}

	// Hard Coded input 
	@Before
	public void setUp() {
		List<String> expression = new ArrayList<>();
		expression.add("7+(6*5^2+3-4/2)");
		expression.add("7+(67(56*2))");
		expression.add("(8*+7");
		expression.add("(8*5/8)-(3/1)-5");
		expression.add("7+(67+(56*2))");
		mathExpression.setExpression(expression);

	}

	@Test
	public final void testExecuteExpression() {
		System.out.println("Valid Expression :");
		mathExpression.getExpression().stream().filter(e -> e != null)
				.map(e -> expressionProcessor.evaluateExpression(e)).filter(e -> e != null).forEach(System.out::println);

	}

	@Test
	public final void testExecuteExpressionwithLambda() {
		List<String> myFinalList = mathExpression.getExpression().stream().filter(e -> e != null)
				.map(e -> expressionProcessor.evaluateExpression(e)).collect(Collectors.toList());
		myFinalList.stream().filter(e -> e != null).map(e -> scripter.scriptExecute(e)).forEach(System.out::println);
	}

}
