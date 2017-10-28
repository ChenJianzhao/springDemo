package org.demo.dubbo.callback;

/**
 * Created by cjz on 2017/10/28.
 */
public interface CallbackService {

    void addListener(String key, CallbackListener listener);

}
