package com.liweijian.bos.service;

import com.liweijian.bos.domain.Region;

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
}