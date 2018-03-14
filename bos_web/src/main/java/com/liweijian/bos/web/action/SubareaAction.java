package com.liweijian.bos.web.action;

import com.liweijian.bos.domain.Region;
import com.liweijian.bos.domain.Subarea;
import com.liweijian.bos.service.SubareaService;
import com.liweijian.bos.web.action.base.IBaseAction;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

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


    /**
     * 分页查询
     * */
    public String quaryPage() throws Exception {

        //组合查询条件
        DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
        String addresskey = model.getAddresskey();
        if (StringUtils.isNotBlank(addresskey)){
            detachedCriteria.add(Restrictions.like("addresskey","%"+addresskey+"%"));
        }
        Region region = model.getRegion();
        if (region != null){
            String province = region.getProvince();
            String city = region.getCity();
            String district = region.getDistrict();
            //创建别名
            //直接在查询条件中使用r.province是无法解析的，因此必须要创建一个别名
            detachedCriteria.createAlias("region","r");
            if (StringUtils.isNotBlank(province)){
                detachedCriteria.add(Restrictions.like("r.province","%"+province+"%"));
            }
            if (StringUtils.isNotBlank(city)){
                detachedCriteria.add(Restrictions.like("r.city","%"+city+"%"));
            }
            if (StringUtils.isNotBlank(district)){
                detachedCriteria.add(Restrictions.like("r.district","%"+district+"%"));
            }
        }

        //查询
        subareaService.quaryPage(pageBean);
        this.java2Json(pageBean,new String[]{"subareas"});
        return NONE;
    }
}
