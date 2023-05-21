package com.pengxin.mapper;

import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseSection;
import com.pengxin.pojo.CourseVo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/15 9:29
 */
public interface CourseContenMapper {
    /*
    * 根据id查询课程内容管理信息(课时类和章节类)
    * */
    public List<CourseSection> findSectionAndLessionByCourseId(Integer id);

    /*
    * 查询回显章节对应的课程信息
    * */
    public Course findCourseByCourseId(Integer id);

    /*新增章节信息
    * */
    public void saveCourseSection(CourseSection courseSection);

    /*
    * 修改章节信息
    * */
    public void updateCourseSection(CourseSection courseSection);

    /*
    * 修改章节状态
    * */
    public void updateCourseSectionStatus(CourseSection courseSection);
}
