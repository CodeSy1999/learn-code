package com.codeashuai.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 13:16
 */
@Entity
@Table(name = "authority")
@Data
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Integer authorityId;
    @Column(name = "authority_registy")
    private Boolean authorityRegisty;
    @Column(name = "authority_thread")
    private Boolean authorityThread;
    @Column(name = "authority_promotion")
    private Boolean authorityPromotion;
    @Column(name = "authority_others")
    private Boolean authorityOthers;

    @ManyToMany(mappedBy = "adminAuthority")
    @ToString.Exclude
    private List<Admin> authorityAdmin;

    public Authority() {
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return "ROLE_"+authorityId;
    }
}
