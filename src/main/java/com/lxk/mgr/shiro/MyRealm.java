package com.lxk.mgr.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liuxiaokun
 * @version 1.0.0
 * @since 2022-09-21 22:01
 */
public class MyRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> set = new HashSet<>();
        set.add("user:list");
        set.add("user:admin");
        info.setStringPermissions(set);
        return null;
    }

    /**
     * 这里可以注入userService,为了方便演示，我就写死了帐号了密码
     * <p>private UserService userService</p>
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("-------身份认证方法--------");
        String userName = (String) authenticationToken.getPrincipal();
        String userPwd = new String((char[]) authenticationToken.getCredentials());
        //根据用户名从数据库获取密码
        String password = "123";
        if (userName == null) {
            throw new AccountException("用户名不正确");
        } else if (!userPwd.equals(password)) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(userName, password, getName());
    }
}
