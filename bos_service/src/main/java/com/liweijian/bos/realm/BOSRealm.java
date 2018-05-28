package com.liweijian.bos.realm;

import com.liweijian.bos.dao.FunctionDao;
import com.liweijian.bos.dao.IUserDao;
import com.liweijian.bos.domain.Function;
import com.liweijian.bos.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

/**
 * @Author:Liweijian
 * @Description: shiro框架的认证和授权Realm
 * @Date:Create in 20:16 2018/3/31 0031
 */
public class BOSRealm extends AuthorizingRealm {

    @Autowired
    IUserDao userDao;

    @Autowired
    FunctionDao functionDao;

    /**
     * 认证
     * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        String username = token.getUsername();
        User user = userDao.findUserByUsername(username);

        if (user == null){
            return null;
        }

        //由框架进行自动比对密码是否和输入的一致
        AuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(),this.getName());
        return info;
    }

    /**
     * 授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Function> list = null;

        if (user.getUsername().equals("admin")){
            //如果是admin，则将所有权限授予他
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Function.class);
            list = functionDao.findByCriteria(detachedCriteria);
        }else {
            //如果不是，则根据
            list = functionDao.findFunctionListByUserId(user.getId());
        }

        for (Function function:list) {
            info.addStringPermission(function.getCode());
        }
        return info;
    }

}
