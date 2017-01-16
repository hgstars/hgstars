package com.hgstars.wechat;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by yujindong on 17/1/16.
 */
@Data
@ToString
@EqualsAndHashCode
public class TokenDto implements Serializable{
    private static final long serialVersionUID = 857303424073602732L;

    @JsonProperty("access_token")
    private String token;
    @JsonProperty("expires_in")
    private String expires;
}
