package com.pengxin.service.Impl;

import com.pengxin.mapper.PromotionSpaceMapper;
import com.pengxin.pojo.PromotionSpace;
import com.pengxin.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/15 19:51
 */
@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    @Override
    public List<PromotionSpace> findPromotionSpace() {
        return promotionSpaceMapper.findPromotionSpace();
    }

    /*
    * 插入广告位
    * */
    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        //封装数据
        UUID uuid = UUID.randomUUID();
        promotionSpace.setSpaceKey(uuid.toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);

        //调用mapper层
        promotionSpaceMapper.savePromotionSpace(promotionSpace);

    }
/*
*   /*根据id回显广告位信息*/
    @Override
    public List<PromotionSpace> findPromotionSpaceById(Integer id) {
        List<PromotionSpace> promotionSpaceList = promotionSpaceMapper.findPromotionSpaceById(id);
        return promotionSpaceList;
    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        //封装数据
        Date date = new Date();
        promotionSpace.setUpdateTime(date);
        //调用mapper层
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }


}
