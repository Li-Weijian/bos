package com.liweijian.bos.web.action;

import com.liweijian.bos.domain.Subarea;
import com.liweijian.bos.service.SubareaService;
import com.liweijian.bos.web.action.base.IBaseAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 11:01 2018/3/12 0012
 */
@Controller
public class SubareaAction extends IBaseAction<Subarea> {

    @Autowired
    private SubareaService subareaService;


    /**
     * 保存分区
     * */
    public String save() throws Exception {

        subareaService.save(model);
        return LIST;
    }
}
