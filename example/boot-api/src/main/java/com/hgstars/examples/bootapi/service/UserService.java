package com.hgstars.examples.bootapi.service;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.hgstars.examples.bootapi.domain.User;
import com.hgstars.examples.bootapi.repository.UserDao;
import com.hgstars.examples.bootapi.service.exception.ErrorCode;
import com.hgstars.examples.bootapi.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.utils.Digests;
import org.springside.modules.utils.Encodes;
import org.springside.modules.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Created by yujindong on 16/12/7.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private CounterService counterService;


    @Value("${app.loginTimeoutSecs:600}")
    private int loginTimeoutSecs;

    // guava cache
    private Cache<String, User> loginUsers;


    @PostConstruct
    public void init() {
        loginUsers = CacheBuilder.newBuilder().maximumSize(1000).expireAfterAccess(loginTimeoutSecs, TimeUnit.SECONDS)
                .build();
    }
    @Transactional(readOnly = true)
    public String login(String email, String password) {
        User user = userDao.findByEmail(email);

        if (user == null) {
            throw new ServiceException("User not exist", ErrorCode.UNAUTHORIZED);
        }

        if (!user.hashPassword.equals(hashPassword(password))) {
            throw new ServiceException("Password wrong", ErrorCode.UNAUTHORIZED);
        }

        String token = Ids.uuid2();
        loginUsers.put(token, user);
        counterService.increment("loginUser");
        return token;
    }

    public User getLoginUser(String token) {

        User user = loginUsers.getIfPresent(token);

        if (user == null) {
            throw new ServiceException("User doesn't login", ErrorCode.UNAUTHORIZED);
        }

        return user;
    }

    @Transactional
    public void register(String email, String name, String password) {
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            throw new ServiceException("Invalid parameter", ErrorCode.BAD_REQUEST);
        }

        User user = new User();
        user.email = email;
        user.name = name;
        user.hashPassword = hashPassword(password);
        userDao.save(user);
    }

    protected static String hashPassword(String password) {
        return Encodes.encodeBase64(Digests.sha1(password));
    }
}
