package com.hgstars.models.mysql;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by yujindong on 16/12/22.
 */
public enum GenderEnum {

    GENDER_SECRECY(0, "保密"),
    GENDER_MALE(1, "男"),
    GENDER_FEMALE(2, "女"),
    GENDER_OTHER(3, "其他");


    public int value;
    public String name;

    GenderEnum(int id, String name) {
        this.value = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
