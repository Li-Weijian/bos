package com.liweijian.bos.web.interceptor;

import com.liweijian.bos.domain.User;
import com.liweijian.bos.utils.BosUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * @Author:Liweijian
 * @Description: 登录拦截器
 * @Date:Create in 22:26 2018/2/25 0025
 */
public class BosLoginInterceptor extends MethodFilterInterceptor {

    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        //获得action名字和命名空间
        ActionProxy proxy = actionInvocation.getProxy();
        String actionName = proxy.getActionName();
        String namespace = proxy.getNamespace();


        //从session中获取登录用户
        User user = BosUtils.getLoginUser();

        if (user == null) {
            //没有登录
            return "login";
        }
        //已经登录，放行
        return actionInvocation.invoke();
    }
}
