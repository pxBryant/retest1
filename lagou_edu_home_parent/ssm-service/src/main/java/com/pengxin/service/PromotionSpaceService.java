package com.pengxin.service;

import com.pengxin.pojo.PromotionSpace;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/15 19:50
 */
public interface PromotionSpaceService {
    /*
     * 查询广告位信息
     * */
    public List<PromotionSpace> findPromotionSpace();

    /*插入广告位
    * */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*根据id回显广告位信息
    * */
    public List<PromotionSpace> findPromotionSpaceById(Integer id);

    /*
    * 更新广告位信息
    * */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
