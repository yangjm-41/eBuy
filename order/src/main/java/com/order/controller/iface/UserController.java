package com.order.controller.iface;

import com.ebuy.user.entity.User;
import com.order.controller.iface.hys.UserControllerHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "SERVER-USER", fallback = UserControllerHystrix.class)
public interface UserController {

    @GetMapping("/users/info")
    List<User> getUser();
}
