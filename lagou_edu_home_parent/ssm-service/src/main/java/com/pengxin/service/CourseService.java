package com.pengxin.service;

import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseVo;
import com.pengxin.pojo.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/13 17:01
 */
public interface CourseService {
    /*多条件查询课程信息*/
    public List<Course> findCourseByCondition(CourseVo courseVo);

    /*
     * 测试条件查询
     * */
    public List<Course> findCourseAll();
    public List<Test> findTestAll();
    /*新增教师信息和课程信息
    * */

    public void saveCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    /*
    * 根据id号回显课程信息
    * */
    public CourseVo findCourseById(Integer id);

    /*
    * 更新讲师信息和课程信息
    * */
    public void updateTeacherAndCourse(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    /*更新课程状态信息
    * */
    public void updateCourseStatus(Integer id,Integer status);
}
