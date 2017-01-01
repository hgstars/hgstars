package com.hgstars.system.constant;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 17/1/1.
 */
public enum WXMsgTypeEnum {
    TEXT(WXMsgType.TEXT),
    IMAGE(WXMsgType.IMAGE),
    LOCATION(WXMsgType.LOCATION),
    LINK(WXMsgType.LINK),
    EVENT(WXMsgType.EVENT),
    VIDEO(WXMsgType.VIDEO),
    VOICE(WXMsgType.VOICE);

    private final String type;
    private final String message;
    private WXMsgTypeEnum(final String type) {
        this.type = type;
        this.message = "微信公众号消息类型:" + type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static WXMsgTypeEnum inst(String typeStr) {
        for(WXMsgTypeEnum typeEnum : WXMsgTypeEnum.values()) {
            if(typeEnum.type.equalsIgnoreCase(typeStr)) {
                return typeEnum;
            }
        }
        return null;
    }
}
