package com.qiang.wxmall.product;

import com.qiang.wxmall.repository.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author lq
 * @date 2020-08-26 16:27
 */
@Data
@Entity
public class ProductImage extends EntityBase {

    @Column(columnDefinition = "int(11) comment '图片ID'")
    private Long imageId;

    @Column(columnDefinition = "int(3) comment '顺序'")
    private Integer order;

    @Column(columnDefinition = "int(3) comment '商品ID'")
    private Long productId;
}
