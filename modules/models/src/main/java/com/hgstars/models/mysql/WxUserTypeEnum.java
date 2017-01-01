package com.hgstars.models.mysql;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 17/1/1.
 */
public enum WxUserTypeEnum {
    GTH("gth", "公众号gth用户");

    private final String type;
    private final String description;
    private WxUserTypeEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static WxUserTypeEnum inst(String type) {
        for(WxUserTypeEnum typeEnum : WxUserTypeEnum.values()) {
            if(typeEnum.type.equalsIgnoreCase(type)) {
                return typeEnum;
            }
        }
        return null;
    }
}
