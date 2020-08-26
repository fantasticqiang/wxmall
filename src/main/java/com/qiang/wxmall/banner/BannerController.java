package com.qiang.wxmall.banner;

import com.qiang.wxmall.banner.dto.BannerInfo;
import com.qiang.wxmall.common.MsgCode;
import com.qiang.wxmall.common.PageResult;
import com.qiang.wxmall.controller.BaseController;
import com.qiang.wxmall.image.Image;
import com.qiang.wxmall.image.ImageService;
import com.qiang.wxmall.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lq
 * @date 2020-08-26 10:53
 */
@RestController
@RequestMapping(value = "banner")
public class BannerController extends BaseController<Banner> {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private BannerItemService bannerItemService;

    @Override
    public BaseService service() {
        return bannerService;
    }


    @GetMapping("/{id}")
    public PageResult<BannerInfo> getBannerById(@PathVariable(value = "id") Long id) {
        Optional<Banner> bannerOptional = bannerService.repository().findById(id);
        if (!bannerOptional.isPresent()) {
            return new PageResult(MsgCode.PageResultEmpty);
        }
        List<BannerItem> bannerItems = bannerItemService.findAllByBannerId(id);
        List<Long> ImageIds = bannerItems.stream().map(x -> x.getImgId()).collect(Collectors.toList());
        List<Image> images = imageService.repository().findAllById(ImageIds);
        ArrayList<BannerInfo> list = new ArrayList<>();
        for (BannerItem bannerItem : bannerItems) {
            BannerInfo tmp = new BannerInfo();
            Long imgId = bannerItem.getImgId();
            Optional<Image> ImageOptional = images.stream().filter(x -> x.getId().equals(imgId)).findFirst();
            if (ImageOptional.isPresent()) {
                Image image = ImageOptional.get();
                imageService.addPrefix(image);
                tmp.setImage(image);
                tmp.setKeyWord(bannerItem.getKeyWord());
                list.add(tmp);
            }
        }
        return PageResult.success(list);
    }
}
