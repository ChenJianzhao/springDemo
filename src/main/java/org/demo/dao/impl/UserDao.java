package org.demo.dao.impl;

import org.demo.dao.IUserDao;
import org.demo.model.UserInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by jzchen on 2017/1/10 0010.
 */

@Repository
public class UserDao extends BaseDao<UserInfo> implements IUserDao {
}
