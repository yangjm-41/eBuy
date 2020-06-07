package com.ebuy.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.eBuy.pojo.TbUser;
import com.ebuy.user.service.impl.UserService;
import com.qy.base.comm.MyPage;
import com.qy.base.controller.MyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userPage", method = {RequestMethod.GET, RequestMethod.POST})
    public MyResult getUsers(MyPage page, TbUser tbUser) {
        IPage page1 = userService.list(page, new QueryWrapper<TbUser>(tbUser));
        return new MyResult(page1).ok();
    }
    //
    //@RequestMapping("test")
    //public MyResult getUsers2(MyPage page, TbUser tbUser) {
    //    //return userService.useRpc();
    //}

}
