package com.liweijian.bos.utils;

import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description: 分页查询的工具类
 * @Date:Create in 14:31 2018/3/5 0005
 */
public class PageBean {

    private int pageSize;     //每页显示的记录数
    private int currentPage;  //当前页码
    private int total;   //总记录数
    private List rows;         //每页显示的数据
    private DetachedCriteria detachedCriteria;  //离线查询条件


    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public DetachedCriteria getDetachedCriteria() {
        return detachedCriteria;
    }

    public void setDetachedCriteria(DetachedCriteria detachedCriteria) {
        this.detachedCriteria = detachedCriteria;
    }
}
