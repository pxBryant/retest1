package com.pengxin.service.Impl;

import com.pengxin.mapper.MenuMapper;
import com.pengxin.pojo.Menu;
import com.pengxin.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/19 10:30
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper mapper;
    @Override
    public List<Menu> findMenuAll(Integer pid) {
        /*
        * 查询菜单中所有的父节点信息
        * */
        return mapper.findAllMenu(pid);
    }

    /*根据角色Id查询关联的菜单信息*/
    @Override
    public List<String> findMenuById(Integer pid) {
        return mapper.findMenuById(pid) ;
    }

    @Override
    public List<Menu> finMenuAll() {
        return mapper.findMenuAll();
    }

    @Override
    public List<Menu> findSubMenuListByPid(Integer id) {
        return mapper.findSubMenuListByPid(id);
    }

    @Override
    public Menu findMenuAndId(Integer id) {
        return mapper.findMenuAndId(id);
    }


}
