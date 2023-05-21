package com.pengxin.mapper;

import com.pengxin.pojo.PromotionSpace;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/15 19:40
 */
public interface PromotionSpaceMapper {
    /*
    * 查询广告位信息
    * */
    public List<PromotionSpace> findPromotionSpace();

    /*
    * 插入广告位
    * */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*根据id回显广告位信息
    * */
    public List<PromotionSpace> findPromotionSpaceById(Integer id);

    /*
    * 修改广告位
    * */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
