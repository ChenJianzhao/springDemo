package org.demo.dubbo.mock;

import org.demo.dubbo.DemoService;

public class DemoServiceMock implements DemoService {
	
	public String sayHello(String name) {
		// 你可以伪造容错数据，此方法只在出现RpcException时被执行
		return "容错数据";
	}
}