package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.DecidedzoneDao;
import com.liweijian.bos.dao.SubareaDao;
import com.liweijian.bos.domain.Decidedzone;
import com.liweijian.bos.domain.Subarea;
import com.liweijian.bos.service.DecidedzoneService;
import com.liweijian.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 23:13 2018/3/15 0015
 */
@Service
@Transactional
public class DecidedzoneServiceImpl implements DecidedzoneService {

    @Autowired
    DecidedzoneDao decidedzoneDao;
    @Autowired
    SubareaDao subareaDao;

    /**
     * 保存定区
     * */
    @Override
    public void save(Decidedzone model, String[] subareaid) {

        //因为一的一方已经放弃主键维护，因此交给多的一方维护
        for (String id : subareaid) {
            Subarea subarea = subareaDao.findById(id);
            subarea.setDecidedzone(model);
        }
        decidedzoneDao.save(model);
    }

    @Override
    public void quaryPage(PageBean pageBean) {
        decidedzoneDao.quaryPage(pageBean);
    }
}
