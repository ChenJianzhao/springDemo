package org.demo.webServices;

/**
 * Created by jzchen on 2017/2/19 0019.
 */
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface IHelloWorld {
    //@WebParam(name="arg0")可有可无，为了增强可读性
    public String sayHello(@WebParam(name="userName")String text);
}
