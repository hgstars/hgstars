package com.hgstars.wechat.gth.service.account;

import com.hgstars.models.mysql.User;

/**
 * Created by yujindong on 16/12/22.
 */
public class AccountService {
    public void test(){
        User u = new User();
        u.setId(1l);
        System.out.println(u);
    }
}
