package com.hgstars.models.mysql.base;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yujindong on 17/1/9.
 */
@MappedSuperclass
@Data
public abstract class WxBaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "create_date")
    protected Date createdDate;
}
