package com.hgstars.system.constant;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 17/1/1.
 */
public enum WXMsgEventTypeEnum {
    SUBSCRIBE(WXMsgEventType.SUBSCRIBE),
    UNSUBSCRIBE(WXMsgEventType.UNSUBSCRIBE),
    SCAN(WXMsgEventType.SCAN),
    LOCATION(WXMsgEventType.LOCATION),
    CLICK(WXMsgEventType.CLICK);

    private final String type;
    private final String message;
    private WXMsgEventTypeEnum(final String type) {
        this.type = type;
        this.message = "微信公众号事件消息类型:" + type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static WXMsgEventTypeEnum inst(String typeStr) {
        for(WXMsgEventTypeEnum typeEnum : WXMsgEventTypeEnum.values()) {
            if(typeEnum.type.equalsIgnoreCase(typeStr)) {
                return typeEnum;
            }
        }
        return null;
    }
}
