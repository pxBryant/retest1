package com.pengxin.controller;

import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseVo;
import com.pengxin.pojo.Test;
import com.pengxin.service.CourseService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/14 9:17
 */
@RestController
@RequestMapping("/course")
public class TestController {
    @Autowired
    private CourseService courseService;
    @RequestMapping("/test")
    public List<Course> testController(){

        List<Course> all = courseService.findCourseAll();

        return all;
    }
}
