package com.liweijian.bos.web.action;

import com.liweijian.bos.domain.Decidedzone;
import com.liweijian.bos.service.DecidedzoneService;
import com.liweijian.bos.web.action.base.IBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * @Author:Liweijian
 * @Description: 定区管理
 * @Date:Create in 23:02 2018/3/15 0015
 */
@Controller
@Scope("prototype")
public class DecidedzoneAction extends IBaseAction<Decidedzone> {

    //接收分区id
    String[] subareaid ;

    @Autowired
    DecidedzoneService decidedzoneService;


    /**
     * 保存定区
     * */
    public String save() throws Exception {

        decidedzoneService.save(model,subareaid);

        return LIST;
    }


    /**
     * 分页查询
     * */
    public String quaryPage() throws Exception {
        decidedzoneService.quaryPage(pageBean);
        this.java2Json(pageBean, new String[]{"currentPage","detachedCriteria","pageSize","subareas","decidedzones"});

        return NONE;
    }





    public void setSubareaid(String[] subareaid) {
        this.subareaid = subareaid;
    }

}



