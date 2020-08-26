package com.qiang.wxmall.theme;

import com.qiang.wxmall.repository.BaseRepository;
import com.qiang.wxmall.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lq
 * @date 2020-08-26 15:46
 */
@Service
public class ThemeService extends BaseService<Theme, Long> {

    @Autowired
    private ThemeRepository themeRepository;

    @Override
    public BaseRepository<Theme, Long> repository() {
        return themeRepository;
    }
}
