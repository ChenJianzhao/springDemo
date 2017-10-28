package org.demo.dubbo.callback;

public interface Notify {
	
//	public void onreturn(Person msg, Integer id);
//	
//	public void onthrow(Throwable ex, Integer id);
	
	public void onreturn(String msg, String name);
	
	public void onthrow(Throwable ex, String name);
}
