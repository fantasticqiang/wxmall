package com.qiang.wxmall.banner;

import com.qiang.wxmall.repository.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author lq
 * @date 2020-08-26 10:49
 */
@Data
@Entity
public class Banner extends EntityBase {

    @Column(columnDefinition = "varchar(20) default '' comment 'banner名称'")
    private String name;

    @Column(columnDefinition = "varchar(30) default '' comment 'banner描述'")
    private String description;

    public Banner() {
        super();
    }
}
