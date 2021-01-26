package com.leiduostudy.service.impl;

import com.leiduostudy.entity.Blog;
import com.leiduostudy.mapper.BlogMapper;
import com.leiduostudy.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
