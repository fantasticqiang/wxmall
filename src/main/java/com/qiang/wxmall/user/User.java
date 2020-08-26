package com.qiang.wxmall.user;

import lombok.Data;
import com.qiang.wxmall.repository.EntityBase;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import java.io.Serializable;

@Data
@Entity
public class User extends EntityBase implements Serializable {

    @Column(columnDefinition = "varchar(100) DEFAULT '' COMMENT '密码'")
    private String password;

    @Column(columnDefinition = "varchar(50) DEFAULT '' COMMENT '用户名'")
    private String username;

    @Column(columnDefinition = "varchar(20) DEFAULT '' COMMENT '电话'")
    private String tel;

    @Column(columnDefinition = "varchar(200) DEFAULT '' COMMENT '备注'")
    private String remark;

    @Column(columnDefinition = "json comment '用户信息'")
    @Convert(converter = UserInfoConvert.class)
    private UserInfo userInfo;

    /**
     * 空构造器
     */
    public User() {
    }


}
