package com.pengxin.mapper;

import com.pengxin.pojo.Role;
import com.pengxin.pojo.Role_menu_relation;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/18 11:15
 */
public interface RolesMapper {
    /*
    * 查询所有角色信息
     */
    public List<Role> finRolesAll(Role role);

    /*
    * 清除角色菜单关联信息
    * */
    public void deleteMenuByRoleId(Integer rid);

    /*
    * 为角色分配菜单列表
    * */
    public void addMenuByRoles(Role_menu_relation roleMenuRelation);

    //删除角色信息
    public void deleteRoles(Integer roleid);
}
