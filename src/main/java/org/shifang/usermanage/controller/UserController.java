package org.shifang.usermanage.controller;

import lombok.extern.slf4j.Slf4j;
import org.shifang.usermanage.anno.Log;
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
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public Result getUserById(@PathVariable int id) {
        log.info("getUserById:{}",id);
        User user = userService.getUserById(id);
        return Result.success(user);
    }
    @GetMapping("/all")
    public Result getAllUsers() {
        log.info("getAllUsers");
        List<User> users = userService.getAllUsers();
        return Result.success(users);
    }

    @GetMapping
    public Result getUserByPage(@RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int pageSize) {
        log.info("getUserByPage:{},{}",page,pageSize);
        PageBean pageBean=userService.getUserByPage(page,pageSize);
        return Result.success(pageBean);

    }
    @Log

    @PostMapping
    public Result insertUser(@RequestBody User user) {
        log.info("insertUser:{}",user);
        userService.insertUser(user);
        return Result.success();
    }
    @Log
    @PutMapping
    public Result updateUser(@RequestBody User user) {
        log.info("updateUser:{}",user);
        userService.updateUser(user);
        return Result.success(user);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable int id) {
        log.info("deleteUser:{}",id);
        userService.deleteUser(id);
        return Result.success();
    }
}
