package org.shifang.usermanage;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.Test;
import org.shifang.usermanage.controller.UserController;
import org.shifang.usermanage.mapper.UserMapper;
import org.shifang.usermanage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class UserManageApplicationTests {
    @Autowired
    private UserController userController;
    @Autowired
    private UserMapper userMapper;

    @Test
    void test_Get() {
    User user=userMapper.getUserById(2);
        System.out.println(user);
    }
    @Test
    void test_Delete() {
    userMapper.deleteUser(1);
    }

    @Test
    void testGenJwt() {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("username","shifang");
        claims.put("password","123456");
        String Jwt=Jwts.builder().signWith(io.jsonwebtoken.SignatureAlgorithm.HS256,"shifang")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
                .compact();
        System.out.println(Jwt);
    }

}
