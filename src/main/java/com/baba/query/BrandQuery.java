package com.baba.query;

import com.baba.utils.Constants;

import java.util.ArrayList;
import java.util.List;

public class BrandQuery {
    private Integer id;

    private String name;

    private String description;

    private String imgUrl;

    private String webSite;

    private Integer sort;

    private Boolean isDisplay; //true(1)表示显示；false(0)表示不显示

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite == null ? null : webSite.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(Boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public BrandQuery() {
    }

    public BrandQuery(Integer id, String name, String description, String imgUrl, String webSite, Integer sort, Boolean isDisplay) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.webSite = webSite;
        this.sort = sort;
        this.isDisplay = isDisplay;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", webSite='" + webSite + '\'' +
                ", sort=" + sort +
                ", isDisplay=" + isDisplay +
                '}';
    }

    /**
     * 商标所对应的图片在图片服务器中的网址
     */
    private String imageServerImgUrl;

    public String getImageServerImgUrl() {
        return Constants.IMAGE_SERVER_URL+imgUrl;
    }

    public void setImageServerImgUrl(String imageServerImgUrl) {
        this.imageServerImgUrl = imageServerImgUrl;
    }



    /////////////////////////////////查询字段//////////////////////////////////////////
    /**
     * 表示要从数据库中查询出来的字段的名称，比如：id,name,description
     */
    private String fields;

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    /////////////////////////////////查询条件like//////////////////////////////////////////
    private boolean nameLike;

    public boolean isNameLike() {
        return nameLike;
    }

    public void setNameLike(boolean nameLike) {
        this.nameLike = nameLike;
    }

    /////////////////////////////////order by//////////////////////////////////////////
    private List<FieldOrder> fieldOrders = new ArrayList<>();

    public void orderById(boolean isAsc){
       fieldOrders.add(new FieldOrder("id",isAsc?"asc":"desc"));
    }
    public void orderByName(boolean isAsc){
        fieldOrders.add(new FieldOrder("name",isAsc?"asc":"desc"));
    }

    /////////////////////////////////分页//////////////////////////////////////////
//    private PageQuery pageQuery;
//
//    public PageQuery getPageQuery() {
//        return pageQuery;
//    }
//
//    public void setPageQuery(PageQuery pageQuery) {
//        this.pageQuery = pageQuery;
//    }
}