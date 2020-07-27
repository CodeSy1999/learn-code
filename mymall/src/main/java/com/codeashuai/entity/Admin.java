package com.codeashuai.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 11:24
 */
@Entity
@Table(name = "admin")
public class Admin {

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

    public Admin(String adminName, String adminPwd, String adminGender, String adminImg, Integer adminAuthority) {
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.adminGender = adminGender;
        this.adminImg = adminImg;
        this.adminAuthority = adminAuthority;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminGender() {
        return adminGender;
    }

    public void setAdminGender(String adminGender) {
        this.adminGender = adminGender;
    }

    public String getAdminImg() {
        return adminImg;
    }

    public void setAdminImg(String adminImg) {
        this.adminImg = adminImg;
    }

    public Integer getAdminAuthority() {
        return adminAuthority;
    }

    public void setAdminAuthority(Integer adminAuthority) {
        this.adminAuthority = adminAuthority;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminGender='" + adminGender + '\'' +
                ", adminImg='" + adminImg + '\'' +
                ", adminAuthority=" + adminAuthority +
                '}';
    }
}
