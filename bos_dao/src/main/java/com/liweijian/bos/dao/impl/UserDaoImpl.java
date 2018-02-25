package com.liweijian.bos.dao.impl;

import com.liweijian.bos.dao.IUserDao;
import com.liweijian.bos.dao.base.impl.BaseDaoImpl;
import com.liweijian.bos.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:27 2018/2/24 0024
 */

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao{


    @Override
    public User login(String username, String password) {

        String hql = "FROM User u WHERE u.username = ? AND u.password = ?";

        List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username, password);
        if (list != null && list.size() > 0){
            User user = list.get(0);
            return user;
        }else {
            return null;
        }
    }
}
