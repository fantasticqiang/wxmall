package com.qiang.wxmall.product;

import com.qiang.wxmall.common.PageResult;
import com.qiang.wxmall.controller.BaseController;
import com.qiang.wxmall.image.ImageService;
import com.qiang.wxmall.product.dto.ProductInfo;
import com.qiang.wxmall.service.BaseService;
import org.hibernate.query.criteria.internal.OrderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lq
 * @date 2020-08-26 16:31
 */
@RestController
@RequestMapping("product")
public class ProductController extends BaseController<Product> {

    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @Override
    public BaseService service() {
        return productService;
    }

    @GetMapping("recent")
    public PageResult<ProductInfo> recentProduct() {
        Specification<Product> specificaion = new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.orderBy(criteriaBuilder.desc(root.get("createTime")));
                return query.getRestriction();
            }
        };
        Page<Product> products = productService.repository().findAll(specificaion, PageRequest.of(0, 15));
        List<ProductInfo> productInfos = productToProductInfo(products.getContent());
        return PageResult.success(productInfos);
    }

    private List<ProductInfo> productToProductInfo(List<Product> products) {
        if (products == null || products.size() < 1) {
            return null;
        }
        ArrayList<ProductInfo> result = new ArrayList<>();
        for (Product p : products) {
            ProductInfo productInfo = new ProductInfo();
            productInfo.setName(p.getName());
            productInfo.setMainImageUrl(imageService.addPrefix(p.getMainImgUrl()));
            productInfo.setId(p.getId());
            productInfo.setPrice(p.getPrice());
            result.add(productInfo);
        }
        return result;
    }
}
