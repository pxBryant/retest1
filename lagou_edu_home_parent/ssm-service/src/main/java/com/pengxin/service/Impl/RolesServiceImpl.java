package com.pengxin.service.Impl;

import com.pengxin.mapper.RolesMapper;
import com.pengxin.pojo.Role;
import com.pengxin.pojo.RoleMenuVo;
import com.pengxin.pojo.Role_menu_relation;
import com.pengxin.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/18 11:21
 */
@Service
public class RolesServiceImpl implements RolesService {
    /*
    * 查询所有角色信息
    * */
    @Autowired
    private RolesMapper rolesMapper;
    @Override
    public List<Role> finRolesAll(Role role) {
        return rolesMapper.finRolesAll(role);
    }

    /*
    * 角色分配角色菜单信息
    * */
    @Override
    public void RolesContextMenu(RoleMenuVo roleMenuVo) {
        //1、根据角色删除菜单信息
        rolesMapper.deleteMenuByRoleId(roleMenuVo.getRid());
        //2、角色分配菜单信息
        for (Integer mid:roleMenuVo.getMenuList()){
            //封装数据
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setMenuId(roleMenuVo.getRid());
            Date date = new Date();
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedby("system");
          rolesMapper.addMenuByRoles(role_menu_relation);
        }

    }

    @Override
    public void deleteRoles(Integer id) {
        //先删除与表关联的信息
        rolesMapper.deleteMenuByRoleId(id);
        rolesMapper.deleteRoles(id);
    }


}
