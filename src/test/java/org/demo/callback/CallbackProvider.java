package org.demo.callback;

import org.demo.dubbo.callback.CallbackListener;
import org.demo.dubbo.callback.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by cjz on 2017/10/28.
 */
public class CallbackProvider {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath :consumer.xml");
        context.start();

        CallbackService callbackService = (CallbackService) context.getBean("callbackService") ;
        callbackService.addListener("http://10.20.160.198/wiki/display/dubbo/foo.bar", new CallbackListener() {
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });
    }

}
