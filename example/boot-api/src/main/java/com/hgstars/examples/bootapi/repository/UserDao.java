package com.hgstars.examples.bootapi.repository;

import com.hgstars.examples.bootapi.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yujindong on 16/12/7.
 */
public interface UserDao extends CrudRepository<User, Long>{

    User findByEmail(String email);
}
