package com.liweijian.bos.dao.base.impl;

import com.liweijian.bos.dao.base.IBaseDao;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:12 2018/2/24 0024
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {

    private Class<T> entityClass;

    /*
    * 使用xml注入的时候，配置了SessionFactory，因此可以注入
    * 但是使用注解后，没有注入SessionFactory，因此需要手动注入
    * */
    @Resource //根据类型自动注入
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    public BaseDaoImpl() {
        //获得带泛型的父类
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获得所有泛型参数
        Type[] types = superclass.getActualTypeArguments();
        //将参数动态赋值给entityClass
        entityClass = (Class<T>) types[0];
    }

    @Override
    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
    }

    @Override
    public void delete(T entity) {
        this.getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public T findById(Serializable id) {
        return  this.getHibernateTemplate().get(entityClass,id);
    }

    @Override
    public List<T> findAll() {
        String hql = "FROM "+entityClass.getSimpleName();
        return (List<T>) this.getHibernateTemplate().find(hql);
    }
}
