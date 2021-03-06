package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.StaffDao;
import com.liweijian.bos.domain.Staff;
import com.liweijian.bos.service.StaffService;
import com.liweijian.bos.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:27 2018/3/4 0004
 */

@Service("staffService")
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffDao staffDao;

    @Override
    public void add(Staff model) {
        staffDao.save(model);
    }

    @Override
    public void quaryPage(PageBean pageBean) {
        staffDao.quaryPage(pageBean);
    }

    @Override
    public void deleteBatch(String ids) {
        if (StringUtils.isNotBlank(ids)){
            String[] id = ids.split(",");
            for (int i = 0; i < id.length; i++){
                staffDao.excuteUpdate("staff.delete",id[i]);
            }
        }
    }

    @Override
    public void edit(Staff model) {
        //获取数据库中的staff
        Staff staff = staffDao.findById(model.getId());
        staff.setName(model.getName());
        staff.setTelephone(model.getTelephone());
        staff.setStation(model.getStation());
        staff.setHaspda(model.getHaspda());
        staff.setStandard(model.getStandard());

        staffDao.update(staff);

    }

    @Override
    public List<Staff> listajax() {
        return staffDao.findAll();
    }
}
