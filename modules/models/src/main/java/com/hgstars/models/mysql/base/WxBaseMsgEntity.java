package com.hgstars.models.mysql.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by yujindong on 17/1/9.
 */

@MappedSuperclass
@Data
public class WxBaseMsgEntity extends WxBaseEntity {
    @Column(name = "to_user_name", length = 100, nullable = false)
    protected String toUserName;
    @Column(name = "from_user_name", length = 100, nullable = false)
    protected String fromUserName;
    @Column(name = "create_time", nullable = false)
    protected Long createTime;
    @Column(name = "msg_type", length = 64, nullable = false)
    protected String msgType;
    @Column(name = "msg_id", nullable = true)
    protected Long msgId;

}
