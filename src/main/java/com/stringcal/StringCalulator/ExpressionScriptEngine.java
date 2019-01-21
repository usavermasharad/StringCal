package com.stringcal.StringCalulator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.stringcal.StringCalulator.strcalinterface.Scripter;

public class ExpressionScriptEngine implements Scripter {

	@Override
	public Object scriptExecute(String expression) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		Object result =null;
		try {
			result =   engine.eval(expression);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}

}
