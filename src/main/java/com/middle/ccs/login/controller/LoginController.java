package com.middle.ccs.login.controller;

import com.middle.ccs.hander.ResponseResult;
import com.middle.ccs.login.entity.LoginDTO;
import com.middle.ccs.login.service.LoginService;
import com.middle.ccs.user.entity.UserInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 上报网站后台登陆接口
 * @author 文亮
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("/login")
    public ResponseResult<UserInfo> login(@RequestBody LoginDTO loginDTO) {
        return ResponseResult.success(loginService.login(loginDTO));
    }
}
