package com.tensqaure.common.entity;

import java.util.List;

/**
 * @program: tensquare_parent
 * @description: 分页结果类
 * @author: Linweizhe
 * @create: 2018-12-05 14:40
 **/
public class PageResult<T> {
    private long total;
    private List<T> rows;

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
