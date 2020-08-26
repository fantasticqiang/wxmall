package com.qiang.wxmall.banner;

import com.qiang.wxmall.repository.BaseRepository;
import com.qiang.wxmall.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lq
 * @date 2020-08-26 14:27
 */
@Service
public class BannerItemService extends BaseService<BannerItem, Long> {

    @Autowired
    private BannerItemRepository bannerItemRepository;

    @Override
    public BaseRepository<BannerItem, Long> repository() {
        return bannerItemRepository;
    }

    public List<BannerItem> findAllByBannerId(Long bannerId){
        return bannerItemRepository.findAllByBannerId(bannerId);
    }
}
