package com.liweijian.bos.service;

import com.liweijian.bos.domain.User;
import com.liweijian.bos.utils.PageBean;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 17:15 2018/2/25 0025
 */
public interface UserService {

    public User login(String username, String password);

    void editPassword(String id, String password);

    void save(User model, String[] roleIds);

    void queryPage(PageBean pageBean);
}
