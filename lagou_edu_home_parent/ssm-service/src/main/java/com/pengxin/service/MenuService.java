package com.pengxin.service;

import com.pengxin.pojo.Menu;

import java.lang.management.MemoryUsage;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/19 10:29
 */
public interface MenuService {
    public List<Menu> findMenuAll(Integer pid);

    /*根据角色Id查询关联的菜单信息*/
    public List<String> findMenuById(Integer pid);

    /*
    * 查询所有的菜单信息
    * */
    public List<Menu> finMenuAll();

    /*
    * 根据id查询所有的菜单信息
    * */
    public List<Menu> findSubMenuListByPid(Integer id);

    public  Menu findMenuAndId(Integer id);
}
