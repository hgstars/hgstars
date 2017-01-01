package com.hgstars.models.mysql;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

/**
 * Created by yujindong on 16/12/22.
 */
@Entity
@Table(name = "t_user")
public class User extends BaseUser {
    private static final long serialVersionUID = 9203354690941239953L;
    private UserTypeEnum type = UserTypeEnum.USER;
    private String loginName;                               // 登录名
    private String nickName = "新用户";                      // 昵称
    private GenderEnum gender = GenderEnum.GENDER_SECRECY;  // 性别
    private String mobile;                                  // 移动电话
    private String phone;                                   // 座机
    private String email;                                   // 邮箱

    public User() {
    }

    public User(long id) {
        this.id = id;
    }

    @Column(name = "type", length = 20)
    @Enumerated(value = EnumType.ORDINAL)
    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    @NotBlank
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @NotBlank
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Column(name = "gender", length = 4)
    @Enumerated(EnumType.ORDINAL)
    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
