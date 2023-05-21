package com.pengxin.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pengxin.mapper.ResourceMapper;
import com.pengxin.pojo.Resource;
import com.pengxin.pojo.ResourceCategory;
import com.pengxin.pojo.ResourceVo;
import com.pengxin.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/20 11:05
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;
    @Override
    public PageInfo<Resource> findAllResourcePage(ResourceVo resourceVo) {
        //分页查询
        PageHelper.startPage(resourceVo.getCurrentPage(),resourceVo.getPageSize());
        List<Resource> resourcePage = resourceMapper.findAllResourcePage(resourceVo);
        PageInfo<Resource> pageInfo = new PageInfo<>(resourcePage);

        return pageInfo;
    }

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceMapper.findAllResourceCategory();
    }
}
