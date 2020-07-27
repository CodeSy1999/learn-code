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

    public Authority(Boolean authorityRegisty, Boolean authorityThread, Boolean authorityPromotion, Boolean authorityOthers) {
        this.authorityRegisty = authorityRegisty;
        this.authorityThread = authorityThread;
        this.authorityPromotion = authorityPromotion;
        this.authorityOthers = authorityOthers;
    }

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public Boolean getAuthorityRegisty() {
        return authorityRegisty;
    }

    public void setAuthorityRegisty(Boolean authorityRegisty) {
        this.authorityRegisty = authorityRegisty;
    }

    public Boolean getAuthorityThread() {
        return authorityThread;
    }

    public void setAuthorityThread(Boolean authorityThread) {
        this.authorityThread = authorityThread;
    }

    public Boolean getAuthorityPromotion() {
        return authorityPromotion;
    }

    public void setAuthorityPromotion(Boolean authorityPromotion) {
        this.authorityPromotion = authorityPromotion;
    }

    public Boolean getAuthorityOthers() {
        return authorityOthers;
    }

    public void setAuthorityOthers(Boolean authorityOthers) {
        this.authorityOthers = authorityOthers;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "authorityId=" + authorityId +
                ", authorityRegisty=" + authorityRegisty +
                ", authorityThread=" + authorityThread +
                ", authorityPromotion=" + authorityPromotion +
                ", authorityOthers=" + authorityOthers +
                '}';
    }
}
