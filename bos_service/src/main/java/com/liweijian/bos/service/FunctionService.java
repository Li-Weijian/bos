package com.liweijian.bos.service;

import com.liweijian.bos.domain.Function;
import com.liweijian.bos.utils.PageBean;

import java.util.List;

public interface FunctionService  {
    public List<Function> listajax();

    public void save(Function function);

    public void quaryPage(PageBean pageBean);
}
