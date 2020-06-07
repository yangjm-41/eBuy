package com.ebuy.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eBuy.mapper.UserMapper;


import com.eBuy.pojo.TbUser;
import com.qy.base.comm.MyPage;
import com.qy.base.controller.MyResult;
import com.qy.msg.client.rpc.IMessageRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.qy.base.util.PageUtil.convePage;

@Service
public class UserService extends ServiceImpl<UserMapper, TbUser> {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private IMessageRpc iMessageRpc;

    public IPage<TbUser> list(MyPage page, QueryWrapper<TbUser> queryWrapper) {
        return mapper.selectPage(convePage(page), queryWrapper);
    }

    public MyResult useRpc() {
        MyResult test = iMessageRpc.test("hello     user");

        return test;
    }


}
