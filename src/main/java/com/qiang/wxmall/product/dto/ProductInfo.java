package com.qiang.wxmall.product.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author lq
 * @date 2020-08-26 16:32
 */
@Data
public class ProductInfo {

    private Long id;

    private String name;

    private BigDecimal price;

    private String mainImageUrl;
}
