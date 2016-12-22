package com.hgstars.wechat.gth.service.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yujindong on 16/12/21.
 */
@Component
@Transactional
public class AccountService {

    private static Logger logger = LoggerFactory.getLogger(AccountService.class);
    @Cacheable(value = "system.config", key = "'system.config_'+#id")
    public long test(int id) {
        logger.info("无缓存");
        long result = System.currentTimeMillis();
        return result;
    }
}
