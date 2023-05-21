package com.pengxin.service.Impl;

import com.pengxin.mapper.CourseMapper;
import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseVo;
import com.pengxin.pojo.Teacher;
import com.pengxin.pojo.Test;
import com.pengxin.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/13 17:01
 */
@Service
public class CourseServiceImpl implements CourseService {
    //调用dao层对象
    @Autowired
    private CourseMapper courseMapper;


    @Override
    public List<Course> findCourseByCondition(CourseVo courseVo) {
        List<Course> list = courseMapper.findCourseByCondition(courseVo);
        return list;
    }

    public List<Course> findCourseAll() {
        return courseMapper.findCourseAll();
    }


    public List<Test> findTestAll() {
        return courseMapper.findTestAll();
    }

    @Override
    public void saveCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVo);
        //补全课程信息
        Date date = new Date();
        course.setUpdateTime(date);
        course.setCreateTime(date);
        //保存课程信息
        courseMapper.saveCourse(course);
        //获取新插入的id值
        int id = course.getId();
        //封装讲师信息
        Teacher teacher=new Teacher();
        BeanUtils.copyProperties(teacher,courseVo);

        //补全讲师信息
        teacher.setCourseId(id);
        teacher.setIsDel(0);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        //保存教师信息
        courseMapper.saveTeacher(teacher);

    }

    @Override
    public CourseVo findCourseById(Integer id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateTeacherAndCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course,courseVo);
        //补全课程信息
        Date date = new Date();
        course.setUpdateTime(date);

        //更新课程信息
        courseMapper.updateCourse(course);
        //封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher,courseVo);
        //补全讲师信息
        teacher.setUpdateTime(date);
        teacher.setCourseId(course.getId());
        //更新讲师信息
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(Integer id, Integer status) {
        //封装课程状态信息
        Course course = new Course();
        Date date = new Date();
        course.setId(id);
        course.setStatus(status);
        course.setUpdateTime(date);
        //跟新课程状态信息
        courseMapper.updateCourseStatus(course);


    }


}
