package com.codeashuai.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id")
    private Integer adminId;
    @Column(name = "admin_name")
//    @JsonAlias("username")
    private String adminName;
    @Column(name = "admin_pwd")
//    @JsonAlias("password")
    private String adminPwd;
    @Column(name = "admin_gender")
    private String adminGender;
    @Column(name = "admin_img")
    private String adminImg;
//    @Column(name = "admin_authority")
//    @ManyToMany()
//    private Integer adminAuthority;
    @ManyToMany
    @ToString.Exclude   //不在对实体属性进行toString()所以不会再进行重复调用
//    @JoinTable(name = "admin_authority",joinColumns = @JoinColumn(name =
//            "admin_id"),
//            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    //1、关系维护端，负责多对多关系的绑定和解除
    //2、@JoinTable注解的name属性指定关联表的名字，joinColumns指定外键的名字，关联到关系维护端(Admin)
    //3、inverseJoinColumns指定外键的名字，要关联的关系被维护端(Authority)
    //4、其实可以不使用@JoinTable注解，默认生成的关联表名称为主表表名+下划线+从表表名，
    //即表名为admin_authority
    //关联到主表的外键名：主表名+下划线+主表中的主键列名,即admin_id
    //关联到从表的外键名：主表中用于关联的属性名+下划线+从表的主键列名,即authority_id
    //主表就是关系维护端对应的表，从表就是关系被维护端对应的表
    @JsonIgnore
    private List<Authority> adminAuthority;


    @OneToMany(mappedBy = "aLogAdmin",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore   //
    //级联保存、更新、删除、刷新;延迟加载。当删除Admin，会级联删除该Admin的所有Log
    //拥有mappedBy注解的实体类为关系被维护端
    //mappedBy="aLogAdmin"中的aLogAdmin是ALog中的日志所属那个Admin属性
//    @Column(name = "admin_logs")
    private List<ALog> adminlogs;

    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
//    @Column(name = "admin_msgs")
    private List<Msg> adminMsgs;


    public Admin() {
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //给予角色权限
//        AuthorityPoint authorityPoint = new AuthorityPoint();
//        System.out.println("=========权限：{"+adminAuthority+"}==========");
//        authorityPoint.setAuthorityId("ROLE_"+adminAuthority);
//        return Arrays.asList(authorityPoint);
        return adminAuthority;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return adminName;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return adminPwd;
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
