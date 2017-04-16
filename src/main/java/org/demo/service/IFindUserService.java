package org.demo.service;

import org.demo.model.UserInfo;

import java.io.Serializable;

/**
 * Created by jzchen on 2017/1/15 0015.
 */
public interface IFindUserService {

    public UserInfo findUser(Serializable id);
}
