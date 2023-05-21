package com.pengxin.service;

import com.pengxin.pojo.Role;
import com.pengxin.pojo.RoleMenuVo;
import com.pengxin.pojo.Role_menu_relation;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/18 11:18
 */
public interface RolesService {
    /*
     * 查询角色所有信息
     * */
    public List<Role> finRolesAll(Role role);



    /* 为角色分配菜单列表*/

    public void RolesContextMenu(RoleMenuVo roleMenuVo);

    //删除角色信息
    public void deleteRoles(Integer id);
}