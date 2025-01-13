package org.shifang.usermanage.service;

import org.shifang.usermanage.pojo.PageBean;
import org.shifang.usermanage.pojo.User;

import java.util.List;

public interface UserService {

User getUserById(int id);

List<User> getAllUsers();

void insertUser(User user);

void updateUser(User user);

void deleteUser(int id);

PageBean getUserByPage(int page, int pageSize);

User login(User user);
}
