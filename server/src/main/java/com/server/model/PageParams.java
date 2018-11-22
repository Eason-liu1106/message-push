package com.server.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 分页参数信息
 */
@ApiModel("分页参数")
public class PageParams {
    /**
     * 当前页码
     * <p>
     * 默认第1页
     */
    @ApiModelProperty("页码，默认1")
    @Min(value = 1, message = "页码不能小于1")
    private int pageNum = 1;
    /**
     * 每页记录数
     * <p>
     * 默认1，1-1000
     */
    @ApiModelProperty("页大小，默认1")
    @Min(value = 1, message = "每页数量不能小于1")
    @Max(value = 500, message = "每页数量不能大于500")
    private int pageSize = 1;

    /**
     * 默认构造方法
     */
    public PageParams() {
    }

    /**
     * 构造方法
     *
     * @param pageNum  当前页码
     * @param pageSize 每页记录数
     */
    public PageParams(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    /**
     * 当前页
     * <p>
     * 最小1
     *
     * @param pageNum
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * 每页记录数
     * <p>
     * 最大1000，最小1
     *
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
