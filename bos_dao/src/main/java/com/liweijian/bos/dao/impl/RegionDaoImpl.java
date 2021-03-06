package com.liweijian.bos.dao.impl;

import com.liweijian.bos.dao.RegionDao;
import com.liweijian.bos.dao.base.impl.BaseDaoImpl;
import com.liweijian.bos.domain.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 17:00 2018/3/7 0007
 */
@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao {

    @Override
    public List<Region> findByQ(String q) {

        String hql = "FROM Region r where r.province like ? or r.city like ? or r.district like ? or r.citycode like ? or r.shortcode like ?";
        List<Region> list = (List<Region>) getHibernateTemplate().find(hql, "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%", "%" + q + "%");
        return list;
    }
}
