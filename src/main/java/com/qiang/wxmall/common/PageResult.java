package com.qiang.wxmall.common;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private String code;

    private String msg;

    /**
     * 总条数
     */
    private Long total;
    /**
     * 总页数
     */
    private Long totalPage;
    /**
     * 当前页数据
     */
    private List<T> items;

    public PageResult() {
    }

    public PageResult(MsgCode msgCode) {
        this.code = msgCode.getCode();
        this.msg = msgCode.getMsg();
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public PageResult(MsgCode msgCode, List<T> items) {
        this.code = msgCode.getCode();
        this.msg = msgCode.getMsg();
        this.items = items;
    }


    public static <T> PageResult<T> success(List<T> items) {
        return new PageResult<T>(MsgCode.success, items);
    }
}
