package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.IUserDao;
import com.liweijian.bos.domain.User;
import com.liweijian.bos.service.UserService;
import com.liweijian.bos.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 17:17 2018/2/25 0025
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User login(String username, String password) {
        String passwordByMd5 = MD5Utils.md5(password);
        User user = userDao.login(username, passwordByMd5);
        return user;
    }
}
