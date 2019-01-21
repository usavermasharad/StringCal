package com.stringcal.StringCalulator.main;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Test {
	 public static void main(String[] args) throws ScriptException {
		    ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    String foo = "7+(6*5^2+3-4/2)";
		    System.out.println(engine.eval(foo));
		  } 
}
