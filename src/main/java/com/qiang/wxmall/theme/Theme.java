package com.qiang.wxmall.theme;

import com.qiang.wxmall.repository.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author lq
 * @date 2020-08-26 15:41
 */
@Data
@Entity
public class Theme extends EntityBase {

    @Column(columnDefinition = "varchar(30) default '' comment '主题的名称'")
    private String name;

    @Column(columnDefinition = "varchar(30) default '' comment '主题描述'")
    private String description;

    @Column(columnDefinition = "int(10) default 1 comment '主题图片ID'")
    private Long topicImgId;

    @Column(columnDefinition = "int(10) default 1 comment '头部head图片ID'")
    private Long headImgId;
}
