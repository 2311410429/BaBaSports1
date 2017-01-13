package com.baba.query.product;

import com.baba.query.OrderField;
import com.baba.query.BasicQuery;

/**
 * 品牌  查询专用对象
 */
public class BrandQuery extends BasicQuery{

    /**
     * ==============================批量查询、更新、删除时的Where条件设置======================
     **/
    private Integer id;

    public Integer getId() {
        return id;
    }

    public BrandQuery setId(Integer id) {
        this.id = id;
        return this;
    }

    private String name;

    public String getName() {
        return name;
    }

    public BrandQuery setName(String name) {
        this.name = name;
        return this;
    }

    private boolean nameLike;

    public BrandQuery setNameLike(boolean isLike) {
        this.nameLike = isLike;
        return this;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public BrandQuery setDescription(String description) {
        this.description = description;
        return this;
    }

    private boolean descriptionLike;

    public BrandQuery setDescriptionLike(boolean descriptionLike) {
        this.descriptionLike = descriptionLike;
        return this;
    }

    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public BrandQuery setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    private boolean imgUrlLike;

    public BrandQuery setImgUrlLike(boolean imgUrlLike) {
        this.imgUrlLike = imgUrlLike;
        return this;
    }

    private String webSite;

    public String getWebSite() {
        return webSite;
    }

    public BrandQuery setWebSite(String webSite) {
        this.webSite = webSite;
        return this;
    }

    private boolean webSiteLike;

    public BrandQuery setWebSiteLike(boolean webSiteLike) {
        this.webSiteLike = webSiteLike;
        return this;
    }

    private Integer sort;

    public Integer getSort() {
        return sort;
    }

    public BrandQuery setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    private Boolean isDisplay;

    public Boolean getDisplay() {
        return isDisplay;
    }

    public BrandQuery setDisplay(Boolean display) {
        isDisplay = display;
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
    public BrandQuery orderbyId(boolean isAsc) {
        orderFields.add(new OrderField("id", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：name
     *
     * @param isAsc 是否升序，否则为降序
     */
    public BrandQuery orderbyName(boolean isAsc) {
        orderFields.add(new OrderField("name", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：description
     *
     * @param isAsc 是否升序，否则为降序
     */
    public BrandQuery orderbyDescription(boolean isAsc) {
        orderFields.add(new OrderField("description", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：img_url
     *
     * @param isAsc 是否升序，否则为降序
     */
    public BrandQuery orderbyImgUrl(boolean isAsc) {
        orderFields.add(new OrderField("img_url", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：web_site
     *
     * @param isAsc 是否升序，否则为降序
     */
    public BrandQuery orderbyWebSite(boolean isAsc) {
        orderFields.add(new OrderField("web_site", isAsc ? "ASC" : "DESC"));
        return this;
    }

    /**
     * 设置排序按属性：sort
     *
     * @param isAsc 是否升序，否则为降序
     */
    public BrandQuery orderbySort(boolean isAsc) {
        orderFields.add(new OrderField("sort", isAsc ? "ASC" : "DESC"));
        return this;
    }

}
