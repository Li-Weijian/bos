package com.liweijian.bos.web.action.base;

import com.liweijian.bos.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:40 2018/2/24 0024
 */
public class IBaseAction<T> extends ActionSupport implements ModelDriven<T> {
    public static final String HOME = "home";
    public static final String LIST = "list";

    protected T model;
    protected PageBean pageBean = new PageBean();
    //创建离线提交查询对象
    DetachedCriteria detachedCriteria = null;

    public void setPage(int page) {
        pageBean.setCurrentPage(page);
    }

    public void setRows(int rows) {
        pageBean.setPageSize(rows);
    }

    /**
     * 将指定Java对象转为json，并响应到客户端页面
     * @param o
     * @param exclueds
     */
    public void java2Json(Object o ,String[] exclueds){
        JsonConfig jsonConfig = new JsonConfig();
        //指定哪些属性不需要转json
        jsonConfig.setExcludes(exclueds);
        String json = JSONObject.fromObject(o,jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        try {
            ServletActionContext.getResponse().getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将指定Java对象转为json，并响应到客户端页面
     * @param o
     * @param exclueds
     */
    public void java2Json(List o , String[] exclueds){
        JsonConfig jsonConfig = new JsonConfig();
        //指定哪些属性不需要转json
        jsonConfig.setExcludes(exclueds);
        String json = JSONArray.fromObject(o,jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        try {
            ServletActionContext.getResponse().getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //在构造方法中动态获取泛型的类型
    public IBaseAction() {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        Class<T> clazz = (Class<T>) actualTypeArguments[0];
        detachedCriteria = DetachedCriteria.forClass(clazz);
        pageBean.setDetachedCriteria(detachedCriteria);

        try {
            //T 代表着实体类，Class代表着类.class
            //所以需要利用反射进行实例化
           model = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T getModel() {
        return model;
    }
}
