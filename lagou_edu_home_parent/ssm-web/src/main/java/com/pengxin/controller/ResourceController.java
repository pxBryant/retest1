package com.pengxin.controller;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/20 11:08
 */

import com.github.pagehelper.PageInfo;
import com.pengxin.pojo.Resource;
import com.pengxin.pojo.ResourceCategory;
import com.pengxin.pojo.ResourceVo;
import com.pengxin.pojo.ResponseResult;

import com.pengxin.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resouce")
public class ResourceController {
    /*
    * 资源分页多条件查询
    * */
    @Autowired
    private ResourceService resourceService;
    @RequestMapping("/findResourcePage")
    public ResponseResult findResourcePage(ResourceVo resourceVo){
        PageInfo<Resource> resourcePage = resourceService.findAllResourcePage(resourceVo);
        ResponseResult result = new ResponseResult(true,200,"资源分页多条件查询成功",resourcePage);
        return result;
    }
    /*
     * 查询所有资源分类信息
     */
    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> category = resourceService.findAllResourceCategory();
        ResponseResult result = new ResponseResult(true,200,"查询所有资源分类成功",category);
        return result;
    }
    }
