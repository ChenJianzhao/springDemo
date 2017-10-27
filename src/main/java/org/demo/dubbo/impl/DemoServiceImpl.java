package org.demo.dubbo.impl;

import org.demo.dubbo.DemoService;

import com.alibaba.dubbo.rpc.RpcContext;

/**
 * Created by cjz on 2017/10/24.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        
    	/**
		 * 【※】上下文信息
		 * RpcContext 是一个 ThreadLocal 的临时状态记录器，
		 * 当接收到 RPC 请求，或发起 RPC 请求时，RpcContext 的状态都会变化。
		 */
    	// 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        System.out.println(isProviderSide);
        
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        System.out.println(application);
        
        // 注意：每发起RPC调用，上下文状态会变化
//        yyyService.yyy();
        // 此时本端变成消费端，这里会返回false
//        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        
        return "Hello " + name;
    }
}
