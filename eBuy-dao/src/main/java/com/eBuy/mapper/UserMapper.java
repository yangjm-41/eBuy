package com.eBuy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.eBuy.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;
import sun.misc.Contended;

@Mapper
public interface UserMapper extends BaseMapper<TbUser> {
}
