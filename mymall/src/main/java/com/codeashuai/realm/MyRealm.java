package com.codeashuai.realm;

import com.codeashuai.entity.Admin;
import com.codeashuai.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 13:44
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    AdminService adminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String adminName = (String)principalCollection.getPrimaryPrincipal();
        Admin admin = adminService.getAdminByAdminName(adminName);
        String role = admin.getAdminAuthority()+"";
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //给予权限，就是一个Set<String>集合
        Set<String> roles = new HashSet<>();
        roles.add(role);
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String adminName = (String)token.getPrincipal();
        Admin admin = adminService.getAdminByAdminName(adminName);
        if(admin != null){
            SimpleAuthenticationInfo authenticationInfo = new
                    SimpleAuthenticationInfo(admin
                    .getAdminName(),admin.getAdminPwd(), ByteSource.Util.bytes
                    (adminName), getName());
            return authenticationInfo;
        }else{
            return null;
        }
    }
}
