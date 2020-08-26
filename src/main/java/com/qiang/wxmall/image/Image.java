package com.qiang.wxmall.image;

import com.qiang.wxmall.repository.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author lq
 * @date 2020-08-26 14:07
 */
@Data
@Entity
public class Image extends EntityBase {

    @Column(columnDefinition = "varchar(50) default '' comment 'URL地址'")
    private String url;

    @Column(columnDefinition = "int(10) default 1 comment '来源'")
    private Integer from;
}
