package com.pengxin.service;

import com.github.pagehelper.PageInfo;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.pojo.Role;
import com.pengxin.pojo.User;
import com.pengxin.pojo.UserVo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/17 20:45
 */
public interface UserService {
    /*
    * 用户分页查询和多条件查询
    * */
    public PageInfo findAllUserByPage(UserVo userVo);

    /*
    * 更新用户状态
    * */
    public void updateUserStatus(Integer id,String status);
    /*
    * 用户登录
    * */
    public User login(User user) throws Exception;
    /*
    * 根据id号查询用户当前角色
    * */
    public List<Role> findRolesById(Integer id);

    /*
    * 用户关联信息
    * */
    public void userContextRole(UserVo userVo);


    /*
     * 获取用户权限
     * */
    ResponseResult getUserPermissions(Integer id);
}
