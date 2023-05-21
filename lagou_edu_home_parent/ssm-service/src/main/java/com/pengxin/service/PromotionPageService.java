package com.pengxin.service;

import com.github.pagehelper.PageInfo;
import com.pengxin.pojo.PromotionAd;
import com.pengxin.pojo.PromotionAdVo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/16 19:35
 */
public interface PromotionPageService {
    /*
     * 广告位分页查询信息
     * */
    public PageInfo<PromotionAd> findAllAdByPage(PromotionAdVo promotionAdVo);

    /*
    * 广告位上线线状态信息*/
    public void updatePromotionSpace(Integer id,Integer status);
}
