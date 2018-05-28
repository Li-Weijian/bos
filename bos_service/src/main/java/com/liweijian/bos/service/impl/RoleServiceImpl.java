package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.RoleDao;
import com.liweijian.bos.domain.Function;
import com.liweijian.bos.domain.Role;
import com.liweijian.bos.service.RoleService;
import com.liweijian.bos.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public void save(Role model, String functionIds) {
        if (StringUtils.isNotBlank(functionIds)){
            String[] fIds = functionIds.split(",");
            for (String id:fIds) {
                Function function = new Function(id);
                model.getFunctions().add(function);
            }
        }

        roleDao.save(model);
    }

    @Override
    public void queryPage(PageBean pageBean) {
        roleDao.quaryPage(pageBean);
    }

    @Override
    public List<Role> findAll() {
       return roleDao.findAll();
    }

}
