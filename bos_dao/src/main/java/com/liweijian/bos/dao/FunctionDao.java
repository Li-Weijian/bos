package com.liweijian.bos.dao;

import com.liweijian.bos.dao.base.IBaseDao;
import com.liweijian.bos.domain.Function;

import java.util.List;

public interface FunctionDao extends IBaseDao<Function> {

    List<Function> findAll();

    List<Function> findFunctionListByUserId(String id);
}
