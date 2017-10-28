package org.demo.dubbo.callback;

import java.io.Serializable;

/**
 * Created by cjz on 2017/10/28.
 */
public interface CallbackListener {
    void changed(String msg);
}
