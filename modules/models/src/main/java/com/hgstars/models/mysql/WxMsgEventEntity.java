package com.hgstars.models.mysql;

import com.hgstars.models.mysql.base.WxBaseMsgEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by yujindong on 17/1/9.
 */
@Entity
@Table(name = "t_wx_event")
@Data
@ToString
@EqualsAndHashCode
public class WxMsgEventEntity extends WxBaseMsgEntity {
    @Column(name = "event", length = 64, nullable = false)
    private String event;
    @Column(name = "event_key", length = 100, nullable = true)
    private String eventKey;
    @Column(name = "ticket", length = 100, nullable = true)
    private String ticket;
    @Column(name = "latitude", nullable = true)
    private Double latitude;
    @Column(name = "longitude", nullable = true)
    private Double longitude;
    @Column(name = "precision", nullable = true)
    private Double precision;
}
