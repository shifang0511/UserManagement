package org.shifang.usermanage.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.shifang.usermanage.pojo.PageBean;
import org.shifang.usermanage.pojo.Result;
import org.shifang.usermanage.pojo.User;
import org.shifang.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user",produces = "application/json")
@Slf4j
@Tag(name = "UserController")
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "普通body请求", description = "处理用户提交的普通body请求")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Result createUser(@RequestBody User user) {
        log.info("insertUser:{}",user);
        userService.insertUser(user);
        return Result.success();
    }

    @Operation(summary = "获取用户信息", description = "根据用户ID获取用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getUserById(@PathVariable int id) {
        log.info("getUserById:{}",id);
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    @Operation(summary = "普通body请求")
    @GetMapping("/all")
    public Result getAllUsers() {
        log.info("getAllUsers");
        List<User> users = userService.getAllUsers();
        return Result.success(users);
    }

    @Operation(summary = "普通body请求")

    @GetMapping
    public Result getUserByPage(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int pageSize) {
        log.info("getUserByPage:{},{}",page,pageSize);
        PageBean pageBean=userService.getUserByPage(page,pageSize);
        return Result.success(pageBean);

    }

    @Operation(summary = "更新用户信息", description = "根据用户ID更新用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result updateUser(@PathVariable Long id, @RequestBody User user) {
        log.info("updateUser:{}",user);
        userService.updateUser(user);
        return Result.success(user);
    }


    @Operation(summary = "删除用户", description = "根据用户ID删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteUser(@PathVariable int id) {
        log.info("deleteUser:{}",id);
        userService.deleteUser(id);
        return Result.success();
    }
}
