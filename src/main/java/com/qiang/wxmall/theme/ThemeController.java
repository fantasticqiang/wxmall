package com.qiang.wxmall.theme;

import com.qiang.wxmall.common.PageResult;
import com.qiang.wxmall.controller.BaseController;
import com.qiang.wxmall.image.Image;
import com.qiang.wxmall.image.ImageService;
import com.qiang.wxmall.service.BaseService;
import com.qiang.wxmall.theme.dto.ThemeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lq
 * @date 2020-08-26 15:46
 */
@RestController
@RequestMapping(value = "theme")
public class ThemeController extends BaseController<Theme> {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private ImageService imageService;

    @Override
    public BaseService service() {
        return themeService;
    }

    @GetMapping("/findThemeByIds")
    public PageResult<ThemeInfo> findThemeByIds(@RequestParam(value = "ids") List<Long> ids) {
        List<Theme> themes = themeService.repository().findAllById(ids);
        ArrayList<ThemeInfo> result = new ArrayList<>();
        List<Long> imagesIds = themes.stream().map(x -> x.getTopicImgId()).collect(Collectors.toList());
        List<Image> images = imageService.repository().findAllById(imagesIds);
        for (Theme theme : themes) {
            Optional<Image> imageOptional = images.stream().filter(x -> x.getId().equals(theme.getTopicImgId())).findFirst();
            if (imageOptional.isPresent()) {
                ThemeInfo themeInfo = new ThemeInfo();
                Image image = imageOptional.get();
                imageService.addPrefix(image);
                themeInfo.setTopicImage(image);
                themeInfo.setName(theme.getName());
                themeInfo.setId(theme.getId());
                result.add(themeInfo);
            }
        }
        return PageResult.success(result);
    }

}
