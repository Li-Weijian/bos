package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.SubareaDao;
import com.liweijian.bos.domain.Subarea;
import com.liweijian.bos.service.SubareaService;
import com.liweijian.bos.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 12:14 2018/3/12 0012
 */

@Service
public class SubareaServiceImpl implements SubareaService {

    @Autowired
    private SubareaDao subareaDao;

    /**
     * 保存分区
     * */
    @Override
    public void save(Subarea model) {
        subareaDao.save(model);
    }

    /**
     * 分页查询
     * */
    @Override
    public void quaryPage(PageBean pageBean) {
        subareaDao.quaryPage(pageBean);
    }

    /**
     * 查询全部数据
     * */
    @Override
    public List<Subarea> findAll() {
        return subareaDao.findAll();
    }
}
