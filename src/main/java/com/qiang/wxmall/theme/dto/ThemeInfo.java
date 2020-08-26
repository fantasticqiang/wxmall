package com.qiang.wxmall.theme.dto;

import com.qiang.wxmall.image.Image;
import lombok.Data;

/**
 * @author lq
 * @date 2020-08-26 15:54
 */
@Data
public class ThemeInfo {

    private Long id;

    private Image topicImage;

    private String name;
}
