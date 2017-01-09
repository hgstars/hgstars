package com.hgstars.utils.weixin.mp.utils;

import com.hgstars.models.mysql.WxMsgTextEntity;
import com.hgstars.models.mysql.base.WxBaseMsgEntity;
import com.hgstars.models.mysql.WxMsgEventEntity;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.util.Date;

/**
 * Created by yujindong on 17/1/9.
 */
public class WXXmlUtils {

    private static <T> T msgEntityFactory(
            Class<? extends WxBaseMsgEntity> clazz, Element ele) {
        WxBaseMsgEntity result;
        try {
            result = clazz.newInstance();
            result.setToUserName(strVal(ele, "ToUserName"));
            result.setFromUserName(strVal(ele, "FromUserName"));
            result.setCreateTime(longVal(ele, "CreateTime"));
            result.setCreatedDate(new Date());
            result.setMsgType(strVal(ele, "MsgType"));
            if (ele.element("MsgId") != null) {
                result.setMsgId(longVal(ele, "MsgId"));
            }
            return (T) result;
        } catch (Exception e) {
            // never occurs
            return null;
        }
    }

    public static WxMsgEventEntity getMsgEvent(Element ele) throws DocumentException {
        WxMsgEventEntity result = msgEntityFactory(WxMsgEventEntity.class, ele);
        result.setEvent(strVal(ele, "Event"));
        if (ele.elementText("EventKey") != null) {
            result.setEventKey(strVal(ele, "EventKey"));
        }
        if (ele.elementText("Ticket") != null) {
            result.setEventKey(strVal(ele, "Ticket"));
        }
        return result;
    }

    public static WxMsgTextEntity getMsgText(Element ele) throws DocumentException {
        WxMsgTextEntity result = msgEntityFactory(WxMsgTextEntity.class, ele);
        result.setMsgId(longVal(ele, "MsgId"));
        result.setContent(strVal(ele, "Content"));
        return result;
    }

    private static String strVal(Element ele, String name) {
        return ele.element(name).getStringValue();
    }

    private static Long longVal(Element ele, String name) {
        return Long.valueOf(ele.element(name).getStringValue());
    }

    private static Double doubleVal(Element ele, String name) {
        return Double.valueOf(ele.element(name).getStringValue());
    }
}
