package com.stringcal.StringCalulator.model;

import java.util.List;

public class MathExpression {
	List<String> expression;
	Integer numOfexpression;
	String result;

	
	public MathExpression() {
		super();
	}

	public MathExpression(List<String> expression, Integer numOfexpression) {
		super();
		this.expression = expression;
		this.numOfexpression = numOfexpression;
	}

	public List<String> getExpression() {
		return expression;
	}

	public void setExpression(List<String> expression) {
		this.expression = expression;
	}

	public Integer getNumOfexpression() {
		return numOfexpression;
	}

	public void setNumOfexpression(Integer numOfexpression) {
		this.numOfexpression = numOfexpression;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
}
