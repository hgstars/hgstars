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
@Table(name = "t_wx_text")
@Data
@ToString
@EqualsAndHashCode
public class WxMsgTextEntity extends WxBaseMsgEntity {
    @Column(name = "content", length = 100, nullable = false)
    private String content;
}
