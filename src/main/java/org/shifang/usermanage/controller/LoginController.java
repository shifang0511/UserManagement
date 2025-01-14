package org.shifang.usermanage.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.shifang.usermanage.pojo.Result;
import org.shifang.usermanage.pojo.User;
import org.shifang.usermanage.service.UserService;
import org.shifang.usermanage.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {
    @Autowired
    private UserService userService;

    @Operation(summary = "普通body请求")
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("login:{}",user);
        User u =userService.login(user);
        if(u!=null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("username",u.getUsername());
            claims.put("password",u.getPassword());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }
        return Result.error("登陆失败");
    }
}
