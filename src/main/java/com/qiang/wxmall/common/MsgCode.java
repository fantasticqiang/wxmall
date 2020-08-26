package com.qiang.wxmall.common;

import lombok.Data;

/**
 * @author lq
 * @date 2020-08-26 14:13
 */
@Data
public class MsgCode {

    private String code;

    private String msg;

    public MsgCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // --- common ---
    public static final MsgCode PageResultEmpty = new MsgCode("1001", "查询结果为空");
    public static final MsgCode success = new MsgCode("1000", "查询成功");
}
