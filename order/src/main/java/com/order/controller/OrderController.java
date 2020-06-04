package com.order.controller;

import com.ebuy.user.entity.User;
import com.ebuy.user.service.UserService;
import com.order.controller.iface.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class OrderController {
    @Autowired
    private UserController userController;

    @GetMapping("/orders/userInfo")
    public List<User> getUsers(){

        return userController.getUser();
    }
}
