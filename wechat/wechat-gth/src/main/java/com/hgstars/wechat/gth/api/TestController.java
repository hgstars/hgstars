package com.hgstars.wechat.gth.api;

import com.hgstars.models.mysql.User;
import com.hgstars.wechat.gth.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yujindong on 16/12/21.
 */
@Controller
public class TestController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test(@RequestParam int id) {
        return "" + accountService.test(id);
    }


    @RequestMapping(value = "test/register", method = RequestMethod.GET)
    @ResponseBody
    public String register(@RequestParam(value = "name") String name,
                           @RequestParam(value = "email", defaultValue = "yujindong@test.com") String email,
                           @RequestParam(value = "plainPassword") String plainPassword) {
        User u = new User();
        u.setLoginName(name);
        u.setEmail(email);
        u.setPlainPassword(plainPassword);
        accountService.register(u);
        return "";
    }

    @RequestMapping(value = "user/list", method = RequestMethod.GET)
    @ResponseBody
    public String userList() {
        return accountService.getAllUsers().toString();
    }
}
