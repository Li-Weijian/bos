package com.liweijian.bos.web.action;

import com.google.gson.Gson;
import com.liweijian.bos.domain.Staff;
import com.liweijian.bos.service.StaffService;
import com.liweijian.bos.utils.PageBean;
import com.liweijian.bos.web.action.base.IBaseAction;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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

    //分页数据
    private int page;
    private int rows;
    /**
     * 查询分页数据
     * */
    public String quaryPage() throws Exception {

        PageBean pageBean = new PageBean();

        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        pageBean.setDetachedCriteria(DetachedCriteria.forClass(Staff.class));

        staffService.quaryPage(pageBean);

        String json = JSONObject.fromObject(pageBean).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().write(json);

        return NONE;
    }


    //属性驱动，接收页面提交的ids参数
    private String ids;

    /**
     * 取派员批量删除
     */
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

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
