package com.qiang.wxmall.user;

import lombok.Data;

import java.util.List;

@Data
public class UserInfo {

    private String address;

    private List<String> hobby;
}
