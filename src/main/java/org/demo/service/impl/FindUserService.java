package org.demo.service.impl;

import org.demo.dao.impl.UserDao;
import org.demo.model.UserInfo;
import org.demo.service.IFindUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by jzchen on 2017/1/15 0015.
 */

@Service
public class FindUserService implements IFindUserService {

    public UserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao = null;

    @Override
    public UserInfo findUser(Serializable id) {
        UserInfo userInfo = getUserDao().get(id);
        System.out.println("inner service found user : " +  userInfo.getUsername() + " which id is " + userInfo.getId()+ "\n");
        return userInfo;
    }
}
