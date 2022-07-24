package com.gcc.advp.utils.page;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 *
 * @author zhouwenfnag
 */
@Data
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    // 总记录数
    private int total;

    // 列表数据
    private List<T> list;

    /**
     * 分页
     * @param list   列表数据
     * @param total  总记录数
     */
    public PageResult(List<T> list, long total) {
        this.list = list;
        this.total = (int)total;
    }
}