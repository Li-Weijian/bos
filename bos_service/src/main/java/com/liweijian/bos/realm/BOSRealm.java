package com.liweijian.bos.realm;

import com.liweijian.bos.dao.IUserDao;
import com.liweijian.bos.domain.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Authorizer;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author:Liweijian
 * @Description: shiro框架的认证和授权Realm
 * @Date:Create in 20:16 2018/3/31 0031
 */
public class BOSRealm extends AuthorizingRealm {

    @Autowired
    IUserDao userDao;

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
        return null;
    }

}
