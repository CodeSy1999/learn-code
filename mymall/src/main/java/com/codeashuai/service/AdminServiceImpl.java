package com.codeashuai.service;

import com.codeashuai.entity.Admin;
import com.codeashuai.entity.Authority;
import com.codeashuai.reposity.AdminReposity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 13:47
 */
@Service
public class AdminServiceImpl implements AdminService {

    private Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminReposity adminReposity;

    @Override
    public Admin getAdminByAdminName(String adminName) {
//        return new Admin("admin","88212f91e2e9cf36981a91b6c518af5c","男","url",1);
        Admin admin = adminReposity.findByAdminName(adminName);
        log.info("==========从数据库获取到的admin:{}=========",admin);
        return admin;
    }

    @Override
    public List<Admin> findAll(){
        List<Admin> allAdmins = adminReposity.findAll();
        log.warn("所有查询到的admins：{}",allAdmins);
        for(Admin admin:allAdmins){
            log.warn("包含的admin权限：{}",admin.getAdminAuthority());
            log.warn("包含的admin日志：{}",admin.getAdminlogs());
            log.warn("包含的admin消息：{}",admin.getAdminMsgs());
        }
        return allAdmins;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws
            UsernameNotFoundException {
        log.warn("===============传入的name:{}=============",name);
        Admin admin = adminReposity.getByAdminName(name);
        if(admin == null){
            throw new UsernameNotFoundException("User not authorized.");
        }
        /*else {
            ArrayList<Authority> authorities = new ArrayList<>();
            Authority authority = new Authority();
            authority.setAuthorityId(1);
            authorities.add(authority);
            admin.setAdminAuthority(authorities);
        }*/
        log.warn("查询出的admin:{}",admin);
        return admin;
    }
}
