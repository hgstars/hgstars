package com.hgstars.models.mysql.base;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yujindong on 16/12/22.
 */
@MappedSuperclass
@Data
public abstract class IdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "create_date")
    protected Date createdDate;
}
