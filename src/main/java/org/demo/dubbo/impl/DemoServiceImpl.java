package org.demo.dubbo.impl;

import org.demo.dubbo.DemoService;

/**
 * Created by cjz on 2017/10/24.
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
