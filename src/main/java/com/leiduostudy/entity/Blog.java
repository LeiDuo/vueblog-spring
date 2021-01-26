package com.leiduostudy.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author 学习用leiduo
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("m_blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;

    @NotBlank(message = "标题不可为空")
    private String title;
    @NotBlank(message = "摘要不可为空")
    private String description;
    @NotBlank(message = "内容不可为空")
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime created;

    private Integer status;


}
