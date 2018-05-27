package com.liweijian.bos.web.action;

import com.liweijian.bos.domain.Role;
import com.liweijian.bos.service.RoleService;
import com.liweijian.bos.web.action.base.IBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RoleAction extends IBaseAction<Role> {

    @Autowired
    private RoleService roleService;

    //属性驱动，获取提交上来的functionIds
    private String functionIds;
    /**
     * 添加角色
     * */
    public String add(){
        roleService.save(model,functionIds);
        return "list";
    }

    /**
     * 展示角色列表
     * */
    public String list(){
        roleService.queryPage(pageBean);
        java2Json(pageBean.getRows(),new String[]{"functions","users"});
        return NONE;
    }

    public String getFunctionIds() {
        return functionIds;
    }

    public void setFunctionIds(String functionIds) {
        this.functionIds = functionIds;
    }
}
