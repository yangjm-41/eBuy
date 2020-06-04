package com.order.controller.iface.hys;

import com.ebuy.user.entity.User;
import com.order.controller.iface.UserController;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserControllerHystrix implements UserController {

    @Override
    public List<User> getUser() {
        return new ArrayList<User>();
    }
}
