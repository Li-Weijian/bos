package com.liweijian.bos.dao.base;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:08 2018/2/24 0024
 */
public interface IBaseDao<T> {

    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public T findById(Serializable id);
    public List<T> findAll();


}
