package com.liweijian.bos.utils;

import com.liweijian.bos.domain.User;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 22:28 2018/2/25 0025
 */
public class BosUtils {

    /**
     * 获得session
     * */
    public static HttpSession getSession(){
        return ServletActionContext.getRequest().getSession();
    }

    /**
     * 获得当前登录用户
     * */
    public static User getLoginUser(){
        return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
    }

}
