package com.pengxin.service;

import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseSection;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/15 9:54
 */

public interface CourseCentenService {
    /*课时管理信息(课时类和章节类)*/
    public List<CourseSection> findSectionAndLessionByCourseId(Integer id);

    /*回显课程章节信息*/
    public Course findCourseByCourseId(Integer id);

    /*
    * 新增章节信息
    * */
    public void saveCourseSection(CourseSection courseSection);

    /*
    * 修改章节信息
    * */
    public void updateCourseSection(CourseSection courseSection);

    /*修改章节状态
    * */
    public void updateCourseSectionStatus(Integer id,Integer status);
}
