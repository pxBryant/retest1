package com.pengxin.mapper;

import com.pengxin.pojo.PromotionAd;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/16 19:13
 */
public interface PromotionPageMapper {
    /*
    * 广告位分页查询信息
    * */
    public List<PromotionAd> findAllAdByPage();

    /*
    * 图片上传
    * */

    /*
    * 广告位的上下线状态
    * */
    public void updatePromotionStatus(PromotionAd promotionAd);
}
