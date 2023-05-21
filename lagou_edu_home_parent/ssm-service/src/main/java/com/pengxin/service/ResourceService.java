package com.pengxin.service;

import com.github.pagehelper.PageInfo;
import com.pengxin.pojo.Resource;
import com.pengxin.pojo.ResourceCategory;
import com.pengxin.pojo.ResourceVo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/20 11:05
 */
public interface ResourceService {
    /*资源分页多条件查询
     * */
    public PageInfo<Resource> findAllResourcePage(ResourceVo resourceVo);

    /*
     * 查询所有资源分类信息
     * */
    public List<ResourceCategory> findAllResourceCategory();
}
