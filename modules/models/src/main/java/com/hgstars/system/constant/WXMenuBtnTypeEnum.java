package com.hgstars.system.constant;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 17/1/1.
 */
public enum WXMenuBtnTypeEnum {
    VIEW(WXMenuBtnType.VIEW), CLICK(WXMenuBtnType.CLICK);

    private final String type;
    private final String message;
    private WXMenuBtnTypeEnum(final String type) {
        this.type = type;
        this.message = "微信公众号按钮类型:" + type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static WXMenuBtnTypeEnum inst(String typeStr) {
        for(WXMenuBtnTypeEnum typeEnum : WXMenuBtnTypeEnum.values()) {
            if(typeEnum.type.equalsIgnoreCase(typeStr)) {
                return typeEnum;
            }
        }
        return null;
    }
}
