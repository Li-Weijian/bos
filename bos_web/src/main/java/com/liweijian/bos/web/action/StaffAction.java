package com.liweijian.bos.web.action;

import com.liweijian.bos.domain.Staff;
import com.liweijian.bos.service.StaffService;
import com.liweijian.bos.web.action.base.IBaseAction;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;


/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:19 2018/3/4 0004
 */

@Controller
@Scope("prototype")
public class StaffAction extends IBaseAction<Staff> {


    @Autowired
    private StaffService staffService;

    /**
     * 保存取派员
     * */
    public String save() throws Exception {

        staffService.add(model);
        return LIST;
    }

    /**
     * 查询分页数据
     * */
    public String quaryPage() throws Exception {

        staffService.quaryPage(pageBean);
        this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","decidedzones"});
        return NONE;
    }


    //属性驱动，接收页面提交的ids参数
    private String ids;

    /**
     * 取派员批量删除
     */
    @RequiresPermissions("staff-delete")  //执行这个方法，需要当前用户具有这个权限
    public String delete(){
        staffService.deleteBatch(ids);
        return LIST;
    }

    /**
     * 取派员修改
     * */
    public String edit() throws Exception {
        staffService.edit(model);

        return LIST;
    }

    public String listajax() throws Exception {

        List<Staff> staffList = staffService.listajax();
        java2Json(staffList,new String[]{"decidedzones"});

        return NONE;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public StaffService getStaffService() {
        return staffService;
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
}
