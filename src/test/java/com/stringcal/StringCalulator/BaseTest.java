package com.stringcal.StringCalulator;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.stringcal.StringCalulator.model.MathExpression;
import com.stringcal.StringCalulator.strcalinterface.ExpressionProcessor;
import com.stringcal.StringCalulator.strcalinterface.Scripter;

/**
 * 
 * @author Sharad Kumar Verma
 *
 */
public abstract class BaseTest {
	MathExpression mathExpression = null;
	ExpressionProcessor expressionProcessor = null;
	Scripter scripter = null;
	Map<String, Object> mapExp = null;

	public BaseTest() {
		super();
		mathExpression = new MathExpression();
		mapExp = new HashMap<>();
		expressionProcessor = new ExpressionProcessorImpl();
		scripter = new ExpressionScriptEngine();

	}

	@Test
	public abstract void testObjectCreation();
	
	
}
