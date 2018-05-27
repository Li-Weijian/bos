package com.liweijian.bos.dao.impl;

import com.liweijian.bos.dao.FunctionDao;
import com.liweijian.bos.dao.base.impl.BaseDaoImpl;
import com.liweijian.bos.domain.Function;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FunctionDaoImpl extends BaseDaoImpl<Function> implements FunctionDao {

    public List<Function> findAll(){
        String hql = "From Function where parentFunction is null";
        return (List<Function>) this.getHibernateTemplate().find(hql);
    }



}
