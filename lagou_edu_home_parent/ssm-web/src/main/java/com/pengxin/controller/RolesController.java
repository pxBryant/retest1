package com.pengxin.controller;

import com.pengxin.pojo.Menu;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.pojo.Role;
import com.pengxin.pojo.RoleMenuVo;
import com.pengxin.service.MenuService;
import com.pengxin.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/18 11:22
 */
@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private RolesService rolesService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findRolesAll")
    public ResponseResult findRolesAll(@RequestBody Role role){
        List<Role> roleList = rolesService.finRolesAll(role);
        ResponseResult result = new ResponseResult(true,200,"查询角色信息成功",roleList);
        return  result;

    }
    /*
    查询所有菜单的父节点信息
    * */
    @RequestMapping("/findMenuSAll")
    public ResponseResult findMenuSAll(){
        List<Menu> menuAll = menuService.findMenuAll(-1);
        Map<String,Object> map = new HashMap<>();
        map.put("menuAll",menuAll);
        ResponseResult result = new ResponseResult(true,200,"查询所有菜单的父节点信息成功",map);
        return result;
    }
    /*
    * 根据角色Id查询关联的菜单信息
    * */
    @RequestMapping("/findMenuById")
    public ResponseResult findMenuById(Integer pid){
        List<String> byId = menuService.findMenuById(pid);
        ResponseResult result = new ResponseResult(true,200,"根据角色Id查询关联的菜单信息成功",byId);
        return  result;
    }

    /*
    * 为角色添加菜单列表
    * */
    @RequestMapping("/rolesContextMenu")
    public  ResponseResult RolesContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        rolesService.RolesContextMenu(roleMenuVo);
        ResponseResult result = new ResponseResult(true,200,"角色添加菜单列表成功"," ");
        return  result;
    }

    /*
    * 删除角色信息
    * */
    @RequestMapping("/deleteRoles")
    public ResponseResult deleteRoles(Integer id){
        rolesService.deleteRoles(id);
        ResponseResult result = new ResponseResult(true,200,"删除角色成功",null);
        return result;
    }
}
