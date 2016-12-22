package com.hgstars.examples.bootapi.api;

import com.hgstars.examples.bootapi.domain.User;
import com.hgstars.examples.bootapi.dto.ResultDto;
import com.hgstars.examples.bootapi.dto.ResultCode;
import com.hgstars.examples.bootapi.service.UserService;
import com.hgstars.examples.bootapi.service.exception.ErrorCode;
import com.hgstars.examples.bootapi.service.exception.ServiceException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springside.modules.constants.MediaTypes;

/**
 * Created by yujindong on 16/12/7.
 */
@RestController
public class TestEndPoint {
    private static Logger logger = LoggerFactory.getLogger(TestEndPoint.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "api/test/login", produces = MediaTypes.JSON_UTF_8)
    public ResultDto<String> login (@RequestParam("email") String email, @RequestParam("password") String password) {

        String token = userService.login(email, password);

        return new ResultDto<String>(token, ResultCode.SUCCESS);
    }

    @RequestMapping(value = "api/test/getUserInfo", produces = MediaTypes.JSON_UTF_8)
    public ResultDto<User> getUserInfo(@RequestParam("token") String token) {
        User user = userService.getLoginUser(token);
        return new ResultDto<User>(user ,ResultCode.SUCCESS);
    }


    @RequestMapping(value = "/api/test/register")
    public ResultDto register(@RequestParam("email") String email,
                         @RequestParam(value = "name", required = false) String name, @RequestParam("password") String password) {

        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(name) || StringUtils.isEmpty(password)) {
            throw new ServiceException("User or name or password empty", ErrorCode.BAD_REQUEST);
        }

        userService.register(email, name, password);

        return new ResultDto(null, ResultCode.SUCCESS);

    }
}
