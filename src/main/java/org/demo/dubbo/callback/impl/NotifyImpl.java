package org.demo.dubbo.callback.impl;

import java.util.HashMap;
import java.util.Map;

import org.demo.dubbo.callback.Notify;

public class NotifyImpl implements Notify{

	public Map<String, String> ret = new HashMap<String, String>();
	public Map<String, Throwable> errors = new HashMap<String, Throwable>();
	
	@Override
	public void onreturn(String msg, String name) {
		System.out.println("onreturn:" + msg);
		ret.put(name, msg);
	}

	@Override
	public void onthrow(Throwable ex, String name) {
		System.out.println("onthrow:" + ex.getMessage());
		errors.put(name, ex);
	}

}
