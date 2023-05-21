package com.pengxin.mapper;

import com.pengxin.pojo.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/17 20:33
 */
public interface UserMapper {
    /*
    * 用户分页查询和多条件查询
    * */
    public List<User> findAllUserByPage(UserVo userVo);

    /*
    * 更新用户状态信息
    * */
    public void updateUserStatus(User user);

    /*
    * 用户登录
    * */
    public User login(User user);

    /*根据id号查询用户当前角色
    * */
    public List<Role> findRolesById(Integer id);

    /*
    * 根据id先删除关联的中间表信息
    * */
    public void deleteUserContextRole(Integer userid);
    /*
    * 分配角色
    * */
    public void adduserContextRole(User_Role_relation user_role_relation);
    /**
     *根据角色id,查询角色拥有的顶级菜单信息
     * */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);


    /**
     *根据PID 查询子菜单信息
     * */
    public List<Menu> findSubMenuByPid(int pid);


    /**
     *获取用户拥有的资源权限信息
     * */
    public List<Resource> findResourceByRoleId(List<Integer> ids);


}
