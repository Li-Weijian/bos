package com.liweijian.bos.web.action;

import com.liweijian.bos.domain.User;
import com.liweijian.bos.service.UserService;
import com.liweijian.bos.utils.BosUtils;
import com.liweijian.bos.web.action.base.IBaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;

/**
 * @Author:Liweijian
 * @Description:
 * @Date:Create in 21:51 2018/2/24 0024
 */

@Controller
//设置Scope("prototype")后，将在需要时才进行实例化，否则在启动时就进行实例化
@Scope("prototype")
public class UserAction extends IBaseAction<User> {
    /*模型驱动已经字BaseAction中实现*/

    private String checkcode;

    private User user = getModel();

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * */
    public String login() {

        String validateCode = (String) ActionContext.getContext().getSession().get("key");
        if (StringUtils.isNotBlank(checkcode) && checkcode.equals(validateCode)) {
            User user = userService.login(this.user.getUsername(), this.user.getPassword());
            if (user != null){
                ActionContext.getContext().getSession().put("user", user);
                return HOME;
            }else {
                addActionError("用户名或者密码不正确");
                return LOGIN;
            }
        } else {
            addActionError("验证码不正确");
            return LOGIN;
        }
    }


    /**
     * 用户注销
     * */
    public String logout(){
        ServletActionContext.getRequest().getSession().invalidate();
        return LOGIN;
    }

    /**
     * 修改当前用户密码
     * */
    public String editPassword(){
        String flat = "1";
        String id = BosUtils.getLoginUser().getId();

        try {
            userService.editPassword(id,user.getPassword());
        }catch (Exception e){
            //修改密码失败
            flat = "0";
            e.printStackTrace();
        }

        try {
            ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
            ServletActionContext.getResponse().getWriter().print(flat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return NONE;
    }



    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }
}
