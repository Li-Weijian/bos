package com.liweijian.bos.web.action;

import com.liweijian.bos.domain.Staff;
import com.liweijian.bos.service.StaffService;
import com.liweijian.bos.web.action.base.IBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:19 2018/3/4 0004
 */

@Controller
@Scope("prototype")
public class StaffAction extends IBaseAction<Staff> {

    private Staff staff = getModel();

    @Autowired
    private StaffService staffService;

    /**
     * 保存取派员
     * */
    public String save() throws Exception {

        staffService.add(model);
        return LIST;
    }
}
