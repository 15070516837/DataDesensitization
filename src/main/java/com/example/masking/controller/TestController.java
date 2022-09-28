package com.example.masking.controller;

import com.example.masking.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: demo1
 * @Package: com.example.demo1.controller
 * @ClassName: TestController
 * @Author: json
 * @Description:
 * @Date: 2022/9/28 16:14
 * @Version: 1.0
 */
@RequestMapping
@RestController
public class TestController {

    @GetMapping("getUser")
    public User getUser() {
        User user = new User();
        user.setAge(100);
        user.setName("nihao");
        return user;
    }
}
