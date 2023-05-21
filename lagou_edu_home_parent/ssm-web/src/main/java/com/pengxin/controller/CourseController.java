package com.pengxin.controller;

import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseVo;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/14 9:13
 */

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/findCourseByConditioin")
    public ResponseResult findCourseByConditioin(@RequestBody  CourseVo courseVo){
        List<Course> list = courseService.findCourseByCondition(courseVo);

        ResponseResult result = new ResponseResult(true,200,"响应成功",list);
        return result;
    }

    /*图片文件上传
    * */
    @RequestMapping("/courseUpload")
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
    * 新增、更新课程和教师信息
    *
    * */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrCourseAndTeacher(CourseVo courseVo)
            throws InvocationTargetException, IllegalAccessException {
        if (courseVo.getId()==null){
            //当输入框为空的时候,说明在执行新增操作
            courseService.saveCourseOrTeacher(courseVo);
            ResponseResult result = new ResponseResult(true,200,"新增成功",null);
            return result;
        }else {
            //当输入框不为空的时候,说明在执行更新操作
            courseService.updateTeacherAndCourse(courseVo);
            ResponseResult result = new ResponseResult(true,200,"更新成功",null);
            return result;
        }

    }

    /*
    * 根据id号回显信息
    * */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(Integer id){
        CourseVo courseVo = courseService.findCourseById(id);
        ResponseResult result = new ResponseResult(true,200,"回显成功",courseVo);
        return result;

    }
    /*
    * 更新课程状态信息
    * */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(Integer id,Integer status){

        courseService.updateCourseStatus(id,status);
        Map<String,Integer> map=new HashMap<>();
        map.put("status",status);
        ResponseResult result = new ResponseResult(true,200,"更新课程状态成功",map);
        return result;
    }
}
