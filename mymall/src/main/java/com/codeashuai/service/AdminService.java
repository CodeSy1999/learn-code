package com.codeashuai.service;

import com.codeashuai.entity.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 13:46
 */
@Service
public interface AdminService extends UserDetailsService {

    Admin getAdminByAdminName(String adminName);

    List<Admin> findAll();

}
