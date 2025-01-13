package org.shifang.usermanage.mapper;

import org.apache.ibatis.annotations.*;
import org.shifang.usermanage.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
    User getByUsernameAndPassword(User user) ;

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(int id);

    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    @Insert("INSERT INTO user (id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES (#{id}, #{username}, #{password}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{dept_id}, #{create_time}, #{update_time})")
    void insertUser(User user);

    @Update("UPDATE user SET username = #{username}, password = #{password}, name = #{name}, gender = #{gender}, " +
            "image = #{image}, job = #{job}, entrydate = #{entrydate}, dept_id = #{dept_id}, create_time = #{create_time}, " +
            "update_time = #{update_time} WHERE id = #{id}")
    int updateUser(User user);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(int id);

    @Select("SELECT * FROM user ")
    List<User> getUserByPage();

}