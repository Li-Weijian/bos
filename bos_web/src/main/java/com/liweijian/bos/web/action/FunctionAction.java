package com.liweijian.bos.web.action;

import com.liweijian.bos.domain.Function;
import com.liweijian.bos.service.FunctionService;
import com.liweijian.bos.web.action.base.IBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
@Scope("prototype")
public class FunctionAction extends IBaseAction<Function> {

    @Autowired
    private FunctionService functionService;

    /**
     * 查询所有权限，返回json
     * */
    public String listajax(){

        List<Function> list = functionService.listajax();
        this.java2Json(list,new String[]{"parentFunction","roles","children"});
        return NONE;
    }

    /**
     * 添加权限
     * */
    public String add(){

        functionService.save(getModel());
        return "list";
    }

    /**
     * 展示权限列表
     * */
    public String list(){
        String page = model.getPage();
        pageBean.setCurrentPage(Integer.parseInt(page));
        functionService.quaryPage(pageBean);
        this.java2Json(pageBean,new String[]{"parentFunction","roles","children"});
        return NONE;
    }





}
