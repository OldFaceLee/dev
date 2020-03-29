package com.ai.dev.common.controller.response;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author: lixuejun
 * @date: Create in 2020/3/26 下午12:33
 * @description:
 */
public class PageInfo<T> implements Serializable {
    private static final ForkJoinPool POOL = new ForkJoinPool(30);
    private Integer pageNo = 1;
    private Integer pageSize = 10;
    private long count = 0L;
    private int pageCount = 0;
    private List<T> results;

    public PageInfo() {
    }

    public PageInfo(Integer pageNo, Integer pageSize, long count, List<T> results) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
        this.results = results;
    }

    public <O> PageInfo(Integer pageNo, Integer pageSize, long count, List<O> pResult, Function<O, T> mapFunc) {
        if (pResult != null && !pResult.isEmpty()) {
            this.results = new CopyOnWriteArrayList();
            POOL.submit(() -> {
                Stream var10000 = pResult.parallelStream().map(mapFunc);
                List var10001 = this.results;
                var10000.forEachOrdered(var10001::add);
            }).quietlyJoin();
        } else {
            this.results = Collections.emptyList();
        }

        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.count = count;
    }

    public PageInfo(com.github.pagehelper.PageInfo<T> pageInfo) {
        this.pageNo = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.pageCount = pageInfo.getPages();
        this.results = pageInfo.getList() != null && !pageInfo.getList().isEmpty() ? pageInfo.getList() : Collections.emptyList();
        this.count = pageInfo.getTotal();
    }

    public <O> PageInfo(PageInfo<O> pageInfo, Function<O, T> mapFunc) {
        this.pageNo = pageInfo.getPageNo();
        this.pageSize = pageInfo.getPageSize();
        List<O> pResult = pageInfo.getResults();
        if (pResult != null && !pResult.isEmpty()) {
            this.results = new CopyOnWriteArrayList();
            POOL.submit(() -> {
                Stream var10000 = pResult.parallelStream().map(mapFunc);
                List var10001 = this.results;
                var10000.forEachOrdered(var10001::add);
            }).quietlyJoin();
        } else {
            this.results = Collections.emptyList();
        }

        this.pageCount = pageInfo.getPageCount();
        this.count = pageInfo.getCount();
    }

    public Integer getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public long getCount() {
        return this.count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<T> getResults() {
        return this.results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getPageCount() {
        Long totalCount = this.count;
        Double pages = Math.ceil(totalCount.doubleValue() / (double)this.pageSize);
        this.pageCount = pages.intValue();
        return this.pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}
