package com.hgstars.models.mysql;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 17/1/1.
 */
public enum UserTypeEnum {

    ADMIN("admin", "系统管理员"),
    USER("user", "系统普通用户"),
    WX_GTH("GTH","公众号gth用户"),
    ;

    private final String type;
    private final String description;
    private UserTypeEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static UserTypeEnum inst(String type) {
        for(UserTypeEnum typeEnum : UserTypeEnum.values()) {
            if(typeEnum.type.equalsIgnoreCase(type)) {
                return typeEnum;
            }
        }
        return null;
    }
}
