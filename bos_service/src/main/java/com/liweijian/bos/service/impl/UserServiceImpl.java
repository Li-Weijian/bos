package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.IUserDao;
import com.liweijian.bos.domain.Role;
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

    @Override
    public void editPassword(String id, String password) {
        password = MD5Utils.md5(password);
        userDao.excuteUpdate("user.editPassword",password,id);
    }

    @Override
    public void save(User model, String[] roleIds) {
        model.setPassword(MD5Utils.md5(model.getPassword()));
        if (roleIds != null && roleIds.length > 0){
            for (String roleId:roleIds) {
                Role role = new Role(roleId);
                model.getRoles().add(role);
            }
        }
        userDao.save(model);
    }
}
