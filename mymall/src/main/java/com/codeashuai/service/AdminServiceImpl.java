package com.codeashuai.service;

import com.codeashuai.entity.Admin;
import com.codeashuai.reposity.AdminReposity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
