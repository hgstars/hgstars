package com.hgstars.system.constant;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 17/1/1.
 */
public enum WXMediaTypeEnum {
    IMAGE(WXMediaType.IMAGE),
    MUSIC(WXMediaType.MUSIC),
    PIC_DESC(WXMediaType.PIC_DESC),
    THUMB(WXMediaType.THUMB),
    VIDEO(WXMediaType.VIDEO),
    VOICE(WXMediaType.VOICE),
    DEFAULT(WXMediaType.DEFAULT);

    private final String type;
    private final String message;
    private WXMediaTypeEnum(final String type) {
        this.type = type;
        this.message = "微信公众号媒体消息类型:" + type;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static WXMediaTypeEnum inst(String typeStr) {
        for(WXMediaTypeEnum typeEnum : WXMediaTypeEnum.values()) {
            if(typeEnum.type.equalsIgnoreCase(typeStr)) {
                return typeEnum;
            }
        }
        return null;
    }
}
