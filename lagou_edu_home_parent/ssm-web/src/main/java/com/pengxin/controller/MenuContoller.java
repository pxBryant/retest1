package com.pengxin.controller;

import com.pengxin.pojo.Menu;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/20 9:40
 */
@RestController
@RequestMapping("/menu")
public class MenuContoller {
    /*
     * 所有菜单信息
     * */
    @Autowired
    private MenuService menuService;
    @RequestMapping("/findMenuAll")
    public ResponseResult findMenuAll(){
        List<Menu> menus = menuService.finMenuAll();
        ResponseResult result = new ResponseResult(true,200,"菜单信息查询成功",menus);
        return result;
    }
    /*
    * 根据id查询所有菜单信息
    * */
    @RequestMapping("/findSubMenuListByPid")
    public ResponseResult findSubMenuListByPid(@RequestParam Integer id){
        if (id==-1){
            //当id等于-1的时候,做新增操作,不回显菜单信息
            List<Menu> menuList = menuService.findSubMenuListByPid(id);
            HashMap<String , Object> map = new HashMap<>();
            map.put("menuInfo",null);
            map.put("parentMenuList",menuList);

            ResponseResult result = new ResponseResult(true,200,"新增菜单信息成功",map);
            return result;
        }else{
            //当id不等于-1的时候,做修改操作,回显菜单信息
            Menu menu = menuService.findMenuAndId(id);
            List<Menu> menuList = menuService.findSubMenuListByPid(-1);

            HashMap<String , Object> map = new HashMap<>();
            map.put("menuInfo",menu);
            map.put("parentMenuList",menuList);

            ResponseResult result = new ResponseResult(true,200,"修改菜单信息成功",map);
            return result;
        }

    }
}
