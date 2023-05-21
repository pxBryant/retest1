package com.pengxin.mapper;

import com.pengxin.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.lang.management.MemoryUsage;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/19 10:23
 */
public interface MenuMapper {
    /*
    * 查询菜单的所有父节点信息
    * */
    public List<Menu> findAllMenu(Integer pid);

    /*
    *根据角色id查询已经关联的菜单信息
    * */
   List<String> findMenuById(Integer pid);

   /*
   * 查询所有的菜单信息
   *
   * */
    public List<Menu> findMenuAll();

    /*查询菜单信息
    * */
    public List<Menu> findSubMenuListByPid(Integer pid);
    public Menu findMenuAndId(Integer id);
}
