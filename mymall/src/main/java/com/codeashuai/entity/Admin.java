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
@Data
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

}
