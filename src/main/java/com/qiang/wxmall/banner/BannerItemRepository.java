package com.qiang.wxmall.banner;

import com.qiang.wxmall.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lq
 * @date 2020-08-26 14:26
 */
@Repository
public interface BannerItemRepository extends BaseRepository<BannerItem, Long> {

    List<BannerItem> findAllByBannerId(Long bannerId);
}
