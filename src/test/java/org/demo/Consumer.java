package org.demo;

import org.demo.dubbo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.EchoService;

public class Consumer {
	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:dubbo/consumer.xml" });
		context.start();
		
		
		DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理
		String hello = demoService.sayHello("world"); // 执行远程方法
		System.out.println(hello); // 显示调用结果
		
	
		/**
		 * 【※】使用泛化调用
		 * 泛化接口调用方式主要用于客户端没有 API 接口及模型类元的情况，参数及返回值中的所有POJO 均用 Map 表示，
		 * 通常用于框架集成，比如：实现一个通用的服务测试框架，可通过GenericService 调用所有服务实现。
		 */
		// 基本类型以及Date,List,Map等不需要转换，直接调用
		// 用Map表示POJO参数，如果返回值为POJO也将自动转成Map
//		GenericService barService = (GenericService) context.getBean("demoService");
//		Object result = barService.$invoke("sayHello", new String[] { "java.lang.String" }, new Object[] { "World" });
//		System.out.println(result.toString()); // 显示调用结果
		
		
		/**
		 * 【※】回声测试
		 * 回声测试用于检测服务是否可用，回声测试按照正常请求流程执行，能够测试整个调用是否通畅，可用于监控。
		 * 所有服务自动实现 EchoService 接口，只需将任意服务引用强制转型为 EchoService ，即可使用。
		 */
//		String status = (String)((EchoService)demoService).$echo("OK");
//		System.out.println(status); // 显示调用结果
		
		
		/**
		 * 【※】上下文信息
		 * RpcContext 是一个 ThreadLocal 的临时状态记录器，
		 * 当接收到 RPC 请求，或发起 RPC 请求时，RpcContext 的状态都会变化。
		 */
//		// 远程调用
//		// 本端是否为消费端，这里会返回true
//		boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
//		System.out.println(isConsumerSide);
//		
//		// 获取最后一次调用的提供方IP地址
//		String serverIP = RpcContext.getContext().getRemoteHost();
//		System.out.println(serverIP);
//		
//		// 获取当前服务配置信息，所有配置信息都将转换为URL的参数
//		String application = RpcContext.getContext().getUrl().getParameter("application");
//		System.out.println(application);
//		// 注意：每发起RPC调用，上下文状态会变化
////		yyyService.yyy();
		
		
		/**
		 * 【※】隐式参数
		 */
//		RpcContext.getContext().setAttachment("index", "1"); // 隐式传参，后面的远程调用都会隐式将这些参数发送到服务器端，类似cookie，用于框架集成，不建议常规业务使用
//		xxxService.xxx(); // 远程调用
		
		
		/**
		 * 【※】异步调用
		 */
//		// 此调用会立即返回null
//		fooService.findFoo(fooId);
//		// 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
//		Future<Foo> fooFuture = RpcContext.getContext().getFuture();
//		
//		// 此调用会立即返回null
//		barService.findBar(barId);
//		// 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
//		Future<Bar> barFuture = RpcContext.getContext().getFuture();
//		
//		// 此时findFoo和findBar的请求同时在执行，客户端不需要启动多线程来支持并行，而是借助NIO的非阻塞完成
//		// 如果foo已返回，直接拿到返回值，否则线程wait住，等待foo返回后，线程会被notify唤醒
//		Foo foo = fooFuture.get();
//		// 同理等待bar返回
//		Bar bar = barFuture.get();
//		// 如果foo需要5秒返回，bar需要6秒返回，实际只需等6秒，即可获取到foo和bar，进行接下来的处理。
		
		
	}
}
