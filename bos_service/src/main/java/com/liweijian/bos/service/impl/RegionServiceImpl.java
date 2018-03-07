package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.RegionDao;
import com.liweijian.bos.domain.Region;
import com.liweijian.bos.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:58 2018/3/7 0007
 */

@Service
@Transactional
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionDao regionDao;


    /**
     * 保存导入的区域
     * */
    @Override
    public void save(List<Region> regionList) {
        for (Region region: regionList) {
            regionDao.saveOrUpdate(region);
        }
    }
}