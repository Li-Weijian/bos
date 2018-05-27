package com.liweijian.bos.service.impl;

import com.liweijian.bos.dao.FunctionDao;
import com.liweijian.bos.domain.Function;
import com.liweijian.bos.service.FunctionService;
import com.liweijian.bos.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionDao functionDao;


    @Override
    public List<Function> listajax() {
        List<Function> functionList = functionDao.findAll();
        return functionList;
    }

    @Override
    public void save(Function function) {
        Function parentFunction = function.getParentFunction();
        if (parentFunction != null && parentFunction.getId().equals("")){
            function.setParentFunction(null);
        }
        functionDao.save(function);
    }

    @Override
    public void quaryPage(PageBean pageBean) {
        functionDao.quaryPage(pageBean);
    }
}
