package com.pengxin.controller;

import com.pengxin.pojo.PromotionSpace;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/15 19:52
 */
@RestController
@RequestMapping("/Promotion")
public class PromotionSpaceController {
    @Autowired
    private PromotionSpaceService promotionSpaceService;
    /*查询广告位信息
    * */
    @RequestMapping("/findPromotionSpace")
    public ResponseResult findPromotionSpace(){
        List<PromotionSpace> spaceList = promotionSpaceService.findPromotionSpace();
        ResponseResult result = new ResponseResult(true,200,"查询广告位成功",spaceList);
        return result;
    }
    /*插入和更新广告位
    * */
    @RequestMapping("/saveUpdatePromotionSpace")
    public ResponseResult savePromotionSpace(PromotionSpace promotionSpace){
        if (promotionSpace.getId()==null) {
            //当输入框的id为空的时候需要插入广告位
            promotionSpaceService.savePromotionSpace(promotionSpace);
            ResponseResult result = new ResponseResult(true,200,"插入广告位成功",null);
            return result;
        }else{
            //当输入框的id不为空的时候更新广告位
            promotionSpaceService.savePromotionSpace(promotionSpace);
            ResponseResult result = new ResponseResult(true,200,"更新广告位成功",null);
            return result;
        }

    }

    /*
    * 根据id查询广告位信息
    * */
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(Integer id){
        List<PromotionSpace> spaceList = promotionSpaceService.findPromotionSpaceById(id);
        ResponseResult result = new ResponseResult(true,200,"根据id查询广告位信息成功",spaceList);
        return result;
    }

}
