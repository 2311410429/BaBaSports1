package com.baba.query.product;

import com.baba.query.BasicQuery;
import com.baba.query.OrderField;

import java.util.ArrayList;
import java.util.List;


public class ColorQuery extends BasicQuery {
    /**
     * ==============================批量查询、更新、删除时的Where条件设置======================
     **/
    private Integer id;

    public Integer getId() {
        return id;
    }

    public ColorQuery setId(Integer id) {
        this.id = id;
        return this;
    }

    private String name;

    public String getName() {
        return name;
    }

    public ColorQuery setName(String name) {
        this.name = name;
        return this;
    }

    private boolean nameLike;

    public ColorQuery setNameLike(boolean isLike) {
        this.nameLike = isLike;
        return this;
    }

    private Integer parentId;

    public Integer getParentId() {
        return parentId;
    }

    public ColorQuery setParentId(Integer parentId) {
        this.parentId = parentId;
        return this;
    }

    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public ColorQuery setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    private boolean imgUrlLike;

    public ColorQuery setImgUrlLike(boolean isLike) {
        this.imgUrlLike = isLike;
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
    public ColorQuery orderbyId(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：name
     *
     * @param isAsc 是否升序，否则为降序
     */
    public ColorQuery orderbyName(boolean isAsc) {
        orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：parent_id
     *
     * @param isAsc 是否升序，否则为降序
     */
    public ColorQuery orderbyParentId(boolean isAsc) {
        orderFields.add(new OrderField("parent_id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：img_url
     *
     * @param isAsc 是否升序，否则为降序
     */
    public ColorQuery orderbyImgUrl(boolean isAsc) {
        orderFields.add(new OrderField("img_url", isAsc ? "ASC" : "DESC"));
        return this;
    }

}
