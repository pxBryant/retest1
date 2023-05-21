package com.pengxin.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pengxin.mapper.PromotionPageMapper;
import com.pengxin.pojo.PromotionAd;
import com.pengxin.pojo.PromotionAdVo;
import com.pengxin.service.PromotionPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/16 19:36
 */
@Service
public class PromotionPageServiceImpl implements PromotionPageService {
/*
* 分页查询广告位信息
* */
    @Autowired
    private PromotionPageMapper promotionPageMapper;
    @Override
    public PageInfo<PromotionAd> findAllAdByPage(PromotionAdVo promotionAdVo) {
        PageHelper.startPage(promotionAdVo.getCurrentPage(),promotionAdVo.getPageSize());
        List<PromotionAd> allAdByPage = promotionPageMapper.findAllAdByPage();
        PageInfo<PromotionAd> pageInfo = new PageInfo<>(allAdByPage);
        return pageInfo;
    }
    /*
     * 广告位上下线状态信息
     * */
    @Override
    public void updatePromotionSpace(Integer id, Integer status) {
            //1、封装数据
        PromotionAd promotionAd = new PromotionAd();
        Date date = new Date();
        promotionAd.setUpdateTime(date);
        promotionAd.setSpaceId(id);
        promotionAd.setStatus(status);
            //2、调用mapper层
        promotionPageMapper.updatePromotionStatus(promotionAd);


    }


}
