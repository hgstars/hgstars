package com.hgstars.api.aaa;

import com.hgstars.models.mysql.User;

import java.util.List;

/**
 * Created by yujindong on 16/12/30.
 */
public interface IAccountService {
    public long test(int id);

    public List<User> getAllUsers();
}
