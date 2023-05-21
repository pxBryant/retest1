package com.pengxin.service.Impl;

import com.pengxin.mapper.CourseContenMapper;
import com.pengxin.pojo.Course;
import com.pengxin.pojo.CourseSection;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.service.CourseCentenService;
import com.pengxin.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/15 9:56
 */
@Service
public class CourseCentenServiceImpl implements CourseCentenService {
    //调用dao层
    @Autowired
    private CourseContenMapper contenMapper;

    @Override
    public List<CourseSection> findSectionAndLessionByCourseId(Integer id) {
        return contenMapper.findSectionAndLessionByCourseId(id);
    }

    @Override
    public Course findCourseByCourseId(Integer id) {
        return contenMapper.findCourseByCourseId(id);
    }

    @Override
    public void saveCourseSection(CourseSection courseSection) {
        //新增章节
        Date date = new Date();
        courseSection.setUpdateTime(date);
        courseSection.setCreateTime(date);
        //调用mapp接口

        contenMapper.saveCourseSection(courseSection);
    }

    @Override
    public void updateCourseSection(CourseSection courseSection) {
        //1、补全信息
        Date date = new Date();
        courseSection.setUpdateTime(date);
        //2、调用mapper接口
        contenMapper.updateCourseSection(courseSection);
    }

    @Override
    public void updateCourseSectionStatus(Integer id, Integer status) {
        CourseSection courseSection = new CourseSection();
        //1、补全信息
        Date date = new Date();
        courseSection.setCourseId(id);
        courseSection.setStatus(status);
        courseSection.setUpdateTime(date);
        //2、调用mapper接口
        contenMapper.updateCourseSectionStatus(courseSection);



    }
}
