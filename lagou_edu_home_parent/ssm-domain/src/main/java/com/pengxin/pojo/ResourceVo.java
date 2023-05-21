package com.pengxin.pojo;

/**
 * Created by IntelliJ IDEA.
 *资源信息分页&多条件查询
 * @Author : Bryant
 * @create 2023/5/20 10:50
 */
public class ResourceVo {
    private Integer currentPage=1;
    private Integer pageSize=10;
    private String name;
    private  Integer categoryId;
    private String url;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
