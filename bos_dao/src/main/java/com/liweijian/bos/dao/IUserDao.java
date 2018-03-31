package com.liweijian.bos.dao;

import com.liweijian.bos.dao.base.IBaseDao;
import com.liweijian.bos.domain.User;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:26 2018/2/24 0024
 */
public interface IUserDao extends IBaseDao<User> {
    public User login(String username,String password);

    User findUserByUsername(String username);
}
