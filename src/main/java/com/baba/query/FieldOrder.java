package com.baba.query;

/**
 * 用来封装查询语句中order by后面的内容，比如：order by name asc , description desc
 */
public class FieldOrder{
    private String field;
    private String order;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public FieldOrder() {
    }

    public FieldOrder(String field, String order) {
        this.field = field;
        this.order = order;
    }
}