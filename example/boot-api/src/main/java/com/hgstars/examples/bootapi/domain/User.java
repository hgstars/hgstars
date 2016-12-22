package com.hgstars.examples.bootapi.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by yujindong on 16/12/7.
 */
@Entity
@Table(name = "t_test_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String email;
    public String name;
    public String hashPassword;

    public User() {

    }

    public User(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
