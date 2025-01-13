package org.shifang.usermanage.service.impl;

import com.github.pagehelper.Page;
import org.shifang.usermanage.mapper.UserMapper;
import org.shifang.usermanage.pojo.PageBean;
import org.shifang.usermanage.pojo.User;
import org.shifang.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void insertUser(User user) {
        user.setCreate_time(LocalDateTime.now());
        user.setUpdate_time(LocalDateTime.now());
        userMapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        user.setUpdate_time(LocalDateTime.now());
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public PageBean getUserByPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);

        List<User> users = userMapper.getUserByPage();
        Page<User> p=(Page<User>) users;

        return new PageBean( p.getTotal(), p.getResult());
    }

    @Override
    public User login(User user) {
        return userMapper.getByUsernameAndPassword(user);
    }
}