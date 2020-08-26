package com.qiang.wxmall.banner;

import com.qiang.wxmall.repository.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author lq
 * @date 2020-08-26 14:21
 */
@Data
@Entity
public class BannerItem extends EntityBase {

    @Column(columnDefinition = "int(10) not null comment 'Image表ID'")
    private Long imgId;

    @Column(columnDefinition = "int(10) not null comment 'banner点击跳转类型'")
    private Long type; //跳转类型

    @Column(columnDefinition = "int(10) not null comment '执行关键字，根据不同的type含义不同'")
    private Long keyWord;

    @Column(columnDefinition = "int(10) not null comment 'banner表的ID'")
    private Long bannerId;
}
