package com.liweijian.bos.service;

import com.liweijian.bos.domain.Staff;
import com.liweijian.bos.utils.PageBean;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:27 2018/3/4 0004
 */
public interface StaffService {
    /**
     * 添加取派员
     * */
    void add(Staff model);

    /**
     * 查询分页数据
     * */
    void quaryPage(PageBean pageBean);

    /**
     * 删除取派员
     * */
    void deleteBatch(String ids);

    /**
     * 修改取派员
     *
     * @param model*/
    void edit(Staff model);

    List<Staff> listajax();
}
