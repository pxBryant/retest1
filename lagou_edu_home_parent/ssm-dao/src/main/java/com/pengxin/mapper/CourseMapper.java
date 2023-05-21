package com.pengxin.mapper;

import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseVo;
import com.pengxin.pojo.Teacher;
import com.pengxin.pojo.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/13 16:49
 */
public interface CourseMapper {
    /*多条件查询课程信息
    * */
    public List<Course> findCourseByCondition(CourseVo courseVo);

    /*
    * 测试条件查询
    * */
    public List<Test> findTestAll();
    public List<Course> findCourseAll();

    /*
    * 新增课程信息
    * */
    public void saveCourse(Course course);

    /*
    * 新增教师信息
    * */
    public void saveTeacher(Teacher teacher);

    /*
    *回显课程信息
    * */
    public CourseVo findCourseById(Integer id);

    /*
    * 更新课程信息
    * */
    public void updateCourse(Course course);
    /*
    * 更新讲师信息
    * */
    public void updateTeacher(Teacher teacher);

    /*
    * 更新课程状态信息
    * */
    public void updateCourseStatus(Course course);
}
