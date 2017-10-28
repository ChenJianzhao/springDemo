package org.demo.dubbo.stub;

import org.demo.dubbo.DemoService;

public class DemoServiceStub implements DemoService{

	private final DemoService barService;
	// 构造函数传入真正的远程代理对象
	public DemoServiceStub(DemoService barService) {
		this.barService = barService;
	}
	
	@Override
	public String sayHello(String name) {
		// 此代码在客户端执行, 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等
		try {
			System.out.println("invoke stub");
			return barService.sayHello(name);
		} catch (Exception e) {
			// 你可以容错，可以做任何AOP拦截事项
			return "容错数据";
		}
	}

}
