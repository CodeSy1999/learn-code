package com.codeashuai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 11:24
 */
@Entity
@Table(name = "admin")
@Data
public class Admin implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name="admin_id")
    private Integer adminId;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "admin_pwd")
    private String adminPwd;
    @Column(name = "admin_gender")
    private String adminGender;
    @Column(name = "admin_img")
    private String adminImg;
    @Column(name = "admin_authority")
    private Integer adminAuthority;

    public Admin() {
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //给予角色权限
        AuthorityPoint authorityPoint = new AuthorityPoint();
        authorityPoint.setAuthorityId(adminAuthority+"");
        return Arrays.asList(authorityPoint);
    }

    @Override
    public String getPassword() {
        return adminPwd;
    }

    @Override
    public String getUsername() {
        return adminName;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }


}
