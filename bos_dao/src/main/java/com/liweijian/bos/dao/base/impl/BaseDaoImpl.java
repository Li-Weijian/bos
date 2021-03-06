package com.liweijian.bos.dao.base.impl;

import com.liweijian.bos.dao.base.IBaseDao;
import com.liweijian.bos.domain.Region;
import com.liweijian.bos.domain.User;
import com.liweijian.bos.utils.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:12 2018/2/24 0024
 */

@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW )
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

    @Override
    //通用分页查询方法
    public void quaryPage(PageBean pageBean) {

        int currentPage = pageBean.getCurrentPage();
        int pageSize = pageBean.getPageSize();

        /*
        * 因为pageBean已经封装了pageSize，currentPage，detachedCriteria
        * 所以，我们只需要去数据库查询剩下的两个字段即可
        *
        * */
        //查询totalCount 总记录数
        DetachedCriteria criteria = pageBean.getDetachedCriteria().setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(criteria);
        Long totalCount = list.get(0);
        pageBean.setTotal(totalCount.intValue());

        //查询rows 每页显示的数据
        criteria = pageBean.getDetachedCriteria().setProjection(null);
        //指定Hibernate封装对象的方式
        criteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
        int firstResult = (currentPage - 1) * pageSize;
        int maxResults = pageSize;
        List rows = this.getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
        pageBean.setRows(rows);
    }

    @Override
    public void saveOrUpdate(T entity) {
        this.getHibernateTemplate().saveOrUpdate(entity);
    }

    /**
     * 执行任意更新操作，在实体类的映射文件中配置hql和参数
     * */
    @Override
    public void excuteUpdate(String queryName, Object... objects) {
        Session session = getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery(queryName);

        //为hql参数赋值
        int i = 0;
        for(Object object : objects){
            query.setParameter(i++,object);
        }
        //执行更新
        query.executeUpdate();
    }

    @Override
    public List<T> findByCriteria(DetachedCriteria detachedCriteria) {
        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
    }

}
