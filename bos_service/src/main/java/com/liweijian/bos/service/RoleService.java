package com.liweijian.bos.service;

import com.liweijian.bos.domain.Role;
import com.liweijian.bos.utils.PageBean;

import java.util.List;

public interface RoleService {

    void save(Role model, String functionIds);

    void queryPage(PageBean pageBean);

    List<Role> findAll();
}
