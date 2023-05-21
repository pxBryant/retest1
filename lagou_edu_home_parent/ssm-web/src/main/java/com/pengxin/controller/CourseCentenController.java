package com.pengxin.controller;

import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseSection;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.service.CourseCentenService;
import com.pengxin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/15 10:07
 */

@RestController
@RequestMapping("/courseCenten")
public class CourseCentenController {
    /*
     * 根据id查询课程内容管理信息(课时类和章节类)
     * */
    @Autowired
    private CourseCentenService courseCentenService;

    @RequestMapping("/findAndLessionByCourseId")
    public ResponseResult findSectionAndLessionByCourseId(Integer id){
        List<CourseSection> list = courseCentenService.findSectionAndLessionByCourseId(id);
        ResponseResult result = new ResponseResult(true,200,"课程管理信息成功",list);

        return result;
    }

    /*回显课程章节信息
    * */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCourseByCourseId(Integer id){
        Course course = courseCentenService.findCourseByCourseId(id);
        ResponseResult result = new ResponseResult(true,200,"查询课程章节信息成功",course);
        return  result;
    }

    /*
    * 新增和修改章节信息
    * */
    @RequestMapping("/saceCourseSection")
    public ResponseResult saveCourseSection(CourseSection courseSection){
        if (courseSection.getId()==null){
            //如果章节的id为空,则需要新增章节
            courseCentenService.saveCourseSection(courseSection);
            ResponseResult result = new ResponseResult(true,200,"章节新增成功",null);
            return result;
        }else {

            //如果章节的信息id不为空,则需要更新章节
            courseCentenService.updateCourseSection(courseSection);
            ResponseResult result = new ResponseResult(true,200,"章节更新成功",null);
            return result;
        }

    }
    /*
    * 修改章节状态
    * */
    @RequestMapping("/updateCourseSectionStatus")
    public ResponseResult updateCourseSectionStatus(Integer id,Integer status){
        courseCentenService.updateCourseSectionStatus(id,status);
        Map<String,Integer> map=new HashMap<>();
        map.put("status",status);
        ResponseResult result = new ResponseResult(true,200,"章节状态更新成功",map);
        return result;

    }

}
