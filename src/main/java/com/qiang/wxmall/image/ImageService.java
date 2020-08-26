package com.qiang.wxmall.image;

import com.qiang.wxmall.repository.BaseRepository;
import com.qiang.wxmall.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @date 2020-08-26 14:10
 */
@Service
public class ImageService extends BaseService<Image, Long> {

    @Autowired
    private ImageRepository imageRepository;

    @Value("${image.prefix}")
    private String imgPrefix;

    @Override
    public BaseRepository<Image, Long> repository() {
        return imageRepository;
    }

    public void addPrefix(Image image) {
        if (image == null) {
            return ;
        }
        image.setUrl(imgPrefix + image.getUrl());
    }

    public String addPrefix(String imageUrl) {
        if (StringUtils.isBlank(imageUrl)) {
            return "";
        }
        imageUrl = imgPrefix + imageUrl;
        return imageUrl;
    }
}
