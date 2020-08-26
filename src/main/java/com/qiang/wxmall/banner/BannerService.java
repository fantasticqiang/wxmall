package com.qiang.wxmall.banner;

import com.qiang.wxmall.repository.BaseRepository;
import com.qiang.wxmall.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @date 2020-08-26 10:51
 */
@Service
public class BannerService extends BaseService<Banner, Long> {

    @Autowired
    private BannerRepository bannerRepository;

    @Override
    public BaseRepository<Banner, Long> repository() {
        return bannerRepository;
    }
}
