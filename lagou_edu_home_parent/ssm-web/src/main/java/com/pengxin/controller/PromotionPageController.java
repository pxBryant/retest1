package com.pengxin.controller;

import com.github.pagehelper.PageInfo;
import com.pengxin.pojo.PromotionAd;
import com.pengxin.pojo.PromotionAdVo;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.service.PromotionPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/17 13:11
 */

@RestController
@RequestMapping("/PromotionAd")
public class PromotionPageController {
    @Autowired
    private PromotionPageService promotionPageService;
    @RequestMapping("/findAllPromotinonByPage")
    public ResponseResult findAllByPage(PromotionAdVo promotionAdVo){
        PageInfo<PromotionAd> byPage = promotionPageService.findAllAdByPage(promotionAdVo);
        ResponseResult result = new ResponseResult(true,200,"分页查询成功",byPage);
        return  result;

    }

    /*图片文件上传
     * */
    @RequestMapping("/PromotionUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //1、判断接收的文件是否为空
        if (file.isEmpty()){
            //如果为空,抛出异常
            throw  new RuntimeException();
        }
        //2、获取项目部署路径
        String path = request.getServletContext().getRealPath("/");
        String substring = path.substring(0, path.indexOf("ssm_web"));

        //3、获取原来的文件名
        String originalFilename = file.getOriginalFilename();
        //4、生成新的文件名
        String newFileNmae=System.currentTimeMillis()+originalFilename.substring(originalFilename.lastIndexOf("."));

        //5、实现文件上传
        String uploadPath=substring+"upload\\";
        File filePath = new File(uploadPath, newFileNmae);


        //6、创建目录
        if (filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录"+filePath);
        }
        //实现图片上传
        file.transferTo(filePath);
        //将文件名和图片进行回响
        Map<String,String> map=new HashMap<>();
        map.put("fileName",newFileNmae);
        map.put("filePath","http://localhost:8080/upload/"+newFileNmae);


        ResponseResult result = new ResponseResult(true,200,"图片上传成功",map);
        return result;

    }

    /*
     * 广告位上下线状态信息
     * */
    @RequestMapping("/updatePromotionSpace")
    public ResponseResult updatePromotionSpace(Integer id,Integer status){
        promotionPageService.updatePromotionSpace(id,status);

        ResponseResult result = new ResponseResult(true,200,"广告位状态更新成功",null);
        return  result;
    }

}
