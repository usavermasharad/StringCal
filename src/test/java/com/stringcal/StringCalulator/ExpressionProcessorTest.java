package com.stringcal.StringCalulator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Sharad Kumar Verma
 *
 */
public class ExpressionProcessorTest extends BaseTest {
	
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
	@Override
	@Test
	public void testObjectCreation() {
		assert !Objects.isNull(mathExpression);
		assert !Objects.isNull(expressionProcessor);
		assert !Objects.isNull(scripter);
		assert !Objects.isNull(mapExp);
	}
	
	@Test
	public final void testEvaluateExpression() {
		mathExpression.getExpression().stream().filter(e -> e != null)
		.map(e -> expressionProcessor.evaluateExpression(e)).filter(e -> e != null).forEach(System.out::println);
		
	}



}
