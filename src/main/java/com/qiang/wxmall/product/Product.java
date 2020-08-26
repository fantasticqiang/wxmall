package com.qiang.wxmall.product;

import com.qiang.wxmall.repository.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * @author lq
 * @date 2020-08-26 16:18
 */
@Data
@Entity
public class Product extends EntityBase {

    @Column(columnDefinition = "varchar(20) default '' comment '商品名称'")
    private String name;

    @Column(columnDefinition = "decimal(6,2) default 0.00 comment '商品的价格'")
    private BigDecimal price;

    @Column(columnDefinition = "int(10) default 0 comment '库存'")
    private Long stock;

    @Column(columnDefinition = "varchar(50) comment '主图'")
    private String mainImgUrl;

    @Column(columnDefinition = "int(10) comment '来源，1本地，2公网'")
    private Long from;

    @Column(columnDefinition = "int(10) comment '商品的图片ID'")
    private Long imgId;
}
