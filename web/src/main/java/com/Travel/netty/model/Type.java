package com.Travel.netty.model;
/**
 * 类型
 */
public final class Type {
	private String val;

	public String getVal() {
		return val;
	}

	private Type() {
	}

	private Type(String val) {
		this.val = val;

	} 
	/**
	 * 日志类型
	 */
	public final static Type ERROR=new Type("[ERROR]:");
	public final static Type INFO=new Type("[INFO]:");  
	
}
