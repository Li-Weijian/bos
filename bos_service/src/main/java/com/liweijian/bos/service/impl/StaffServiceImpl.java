package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.StaffDao;
import com.liweijian.bos.domain.Staff;
import com.liweijian.bos.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:27 2018/3/4 0004
 */

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public void add(Staff model) {
        staffDao.save(model);
    }
}
