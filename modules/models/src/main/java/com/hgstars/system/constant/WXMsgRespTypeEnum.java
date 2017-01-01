package com.hgstars.system.constant;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 17/1/1.
 */
public enum WXMsgRespTypeEnum {

    TEXT(WXMsgRespType.TEXT),
    IMAGE(WXMsgRespType.IMAGE),
    MUSIC(WXMsgRespType.MUSIC),
    NEWS(WXMsgRespType.NEWS),
    VIDEO(WXMsgRespType.VIDEO),
    VOICE(WXMsgRespType.VOICE);

    private final String type;
    private final String message;
    private WXMsgRespTypeEnum(final String type) {
        this.type = type;
        this.message = "微信公众号响应消息类型:" + type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static WXMsgRespTypeEnum inst(String typeStr) {
        for(WXMsgRespTypeEnum typeEnum : WXMsgRespTypeEnum.values()) {
            if(typeEnum.type.equalsIgnoreCase(typeStr)) {
                return typeEnum;
            }
        }
        return null;
    }
}
