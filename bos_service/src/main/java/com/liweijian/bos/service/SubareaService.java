package com.liweijian.bos.service;

import com.liweijian.bos.domain.Subarea;
import com.liweijian.bos.utils.PageBean;

import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 11:05 2018/3/12 0012
 */
public interface SubareaService {
    void save(Subarea model);

    void quaryPage(PageBean pageBean);

    List<Subarea> findAll();
}
