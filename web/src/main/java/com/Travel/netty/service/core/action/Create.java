package com.Travel.netty.service.core.action;

import com.Travel.netty.model.JSONtype;
import com.Travel.netty.model.SysCode;
import com.alibaba.fastjson.JSONObject;


/**
 * 创建连接
 */
public final class Create {

	public static Object execute() {
		JSONObject json = new JSONObject();
		json.put("type", JSONtype.CREATE);
		json.put("result", SysCode.success);
		return json.toString();
	}
}
