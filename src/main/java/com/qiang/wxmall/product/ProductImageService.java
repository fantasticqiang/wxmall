package com.qiang.wxmall.product;

import com.qiang.wxmall.repository.BaseRepository;
import com.qiang.wxmall.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @date 2020-08-26 16:30
 */
@Service
public class ProductImageService extends BaseService<ProductImage, Long> {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public BaseRepository<ProductImage, Long> repository() {
        return productImageRepository;
    }

}
