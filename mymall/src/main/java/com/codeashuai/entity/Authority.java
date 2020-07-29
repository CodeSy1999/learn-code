package com.codeashuai.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author shuaiyong
 * @version 1.0
 * @date 2020/7/27 13:16
 */
@Entity
@Table(name = "authority")
@Data
public class Authority {

    @Id
    @GeneratedValue()
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

    public Authority() {
    }

}
