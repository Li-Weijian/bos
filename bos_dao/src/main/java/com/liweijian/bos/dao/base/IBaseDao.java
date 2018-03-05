package com.liweijian.bos.dao.base;

import com.liweijian.bos.utils.PageBean;

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
    public void quaryPage(PageBean pageBean);

    /**
     * 执行任意更新操作，在实体类的映射文件中配置hql和参数
     * */
    public void excuteUpdate(String queryName, Object...objects);

}
