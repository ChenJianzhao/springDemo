package org.demo.service.impl;

import org.apache.log4j.Logger;
import org.demo.dao.IUserDao;
import org.demo.model.UserInfo;
import org.demo.service.ISignUpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by jzchen on 2017/1/10 0010.
 */
@Service
public class SignUpService implements ISignUpService {

    Logger logger = Logger.getLogger(SignUpService.class);

    IUserDao userDao = null;
    /**
     *
     * @param userInfo
     * @return
     * @throws Exception
     */
    @Override
    public String signUp(UserInfo userInfo) {
        return getUserDao().add(userInfo).toString();
    }



    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
