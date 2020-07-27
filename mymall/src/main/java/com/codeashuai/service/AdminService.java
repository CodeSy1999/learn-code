package com.codeashuai.service;

import com.codeashuai.entity.Admin;
import org.springframework.stereotype.Service;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 13:46
 */
@Service
public interface AdminService {

    Admin getAdminByAdminName(String adminName);
}
