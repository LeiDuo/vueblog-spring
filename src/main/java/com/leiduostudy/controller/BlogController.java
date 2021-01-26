package com.leiduostudy.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leiduostudy.common.lang.Result;
import com.leiduostudy.entity.Blog;
import com.leiduostudy.service.BlogService;
import com.leiduostudy.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 学习用leiduo
 * @since 2020-12-29
 */
@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return Result.success(pageData);
    }

    @GetMapping("/blog/{id}")
    public Result detail(@PathVariable(name = "id") long id) {
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");
        return Result.success(blog);
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public Result edit(@Validated @RequestBody Blog blog) {
        Blog temp = null;
        if (blog.getId() != null) {
            temp=blogService.getById(blog.getId());
            //只能编辑自己的文章
            Assert.isTrue(temp.getUserId().equals(ShiroUtil.getProfile().getId()),"没有权限编辑");
        } else {
            temp=new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        BeanUtil.copyProperties(blog,temp,"id","userId","created","status");
        blogService.saveOrUpdate(temp);
        return Result.success(null);
    }
}
