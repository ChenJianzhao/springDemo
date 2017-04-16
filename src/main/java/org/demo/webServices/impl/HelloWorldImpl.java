package org.demo.webServices.impl;

import org.demo.webServices.IHelloWorld;

import javax.jws.WebService;

/**
 * Created by jzchen on 2017/2/19 0019.
 */
@WebService(endpointInterface="org.demo.webServices.IHelloWorld")
public class HelloWorldImpl implements IHelloWorld {
    public String sayHello(String text) {
        return "Hello" + text ;
    }
}
