package com.liweijian.bos.service;

import com.liweijian.bos.domain.Region;
import com.liweijian.bos.utils.PageBean;

import java.util.List; /**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 16:57 2018/3/7 0007
 */
public interface RegionService {

    /**
     * 保存区域
     * */
    void save(List<Region> regionList);

    /**
     * 分页查询
     * */
    void quaryPage(PageBean pageBean);

    /**
     * 查询所有区域
     * */
    List<Region> findAll();

    /**
     * 根据输入条件进行查询
     * */
    List<Region> findByQ(String q);
}
