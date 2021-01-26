package com.leiduostudy.service.impl;

import com.leiduostudy.entity.User;
import com.leiduostudy.mapper.UserMapper;
import com.leiduostudy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 学习用leiduo
 * @since 2020-12-29
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
