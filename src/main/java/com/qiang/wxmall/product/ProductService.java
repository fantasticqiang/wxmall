package com.qiang.wxmall.product;

import com.qiang.wxmall.repository.BaseRepository;
import com.qiang.wxmall.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @date 2020-08-26 16:25
 */
@Service
public class ProductService extends BaseService<Product, Long> {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public BaseRepository<Product, Long> repository() {
        return productRepository;
    }
}
