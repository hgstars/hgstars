package com.hgstars.wechat.gth.repository;

import com.hgstars.models.mysql.User;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yujindong on 16/12/29.
 */
public interface AccountDao extends PagingAndSortingRepository<User, Long>{
    User findUserByLoginName(String loginName);
}
