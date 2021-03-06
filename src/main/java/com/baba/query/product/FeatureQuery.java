package com.baba.query.product;

import com.baba.query.BasicQuery;
import com.baba.query.OrderField;

import java.util.ArrayList;
import java.util.List;


public class FeatureQuery extends BasicQuery {
    /**
     * ==============================批量查询、更新、删除时的Where条件设置======================
     **/
    private Integer id;

    public Integer getId() {
        return id;
    }

    public FeatureQuery setId(Integer id) {
        this.id = id;
        return this;
    }

    private String name;

    public String getName() {
        return name;
    }

    public FeatureQuery setName(String name) {
        this.name = name;
        return this;
    }

    private boolean nameLike;

    public FeatureQuery setNameLike(boolean isLike) {
        this.nameLike = isLike;
        return this;
    }

    private String value;

    public String getValue() {
        return value;
    }

    public FeatureQuery setValue(String value) {
        this.value = value;
        return this;
    }

    private boolean valueLike;

    public FeatureQuery setValueLike(boolean isLike) {
        this.valueLike = isLike;
        return this;
    }

    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public FeatureQuery setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    private Integer isDel;

    public Integer getIsDel() {
        return isDel;
    }

    public FeatureQuery setIsDel(Integer isDel) {
        this.isDel = isDel;
        return this;
    }

    /**
     * ==============================批量查询时的Order条件顺序设置==========================
     **/

    /**
     * 设置排序按属性：id
     *
     * @param isAsc 是否升序，否则为降序
     */
    public FeatureQuery orderbyId(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：name
     *
     * @param isAsc 是否升序，否则为降序
     */
    public FeatureQuery orderbyName(boolean isAsc) {
        orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：value
     *
     * @param isAsc 是否升序，否则为降序
     */
    public FeatureQuery orderbyValue(boolean isAsc) {
        orderFields.add(new OrderField("value", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：sort
     *
     * @param isAsc 是否升序，否则为降序
     */
    public FeatureQuery orderbySort(boolean isAsc) {
        orderFields.add(new OrderField("sort", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：is_del
     *
     * @param isAsc 是否升序，否则为降序
     */
    public FeatureQuery orderbyIsDel(boolean isAsc) {
        orderFields.add(new OrderField("is_del", isAsc ? "ASC" : "DESC"));
        return this;
    }

}
