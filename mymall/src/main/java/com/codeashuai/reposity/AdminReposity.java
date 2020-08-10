package com.codeashuai.reposity;

import com.codeashuai.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 16:28
 */
@Repository
public interface AdminReposity extends JpaRepository<Admin,Integer>{

    Admin findByAdminName(String adminName);

    /**
     * 关联查询出角色对应的权限
     * @param name
     * @return
     */
    @Query("select a from Admin a where a.adminName = ?1")
    Admin getByAdminName(String name);
}
