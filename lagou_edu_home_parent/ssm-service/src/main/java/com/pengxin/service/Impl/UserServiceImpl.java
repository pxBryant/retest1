package com.pengxin.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pengxin.mapper.UserMapper;
import com.pengxin.pojo.*;
import com.pengxin.service.UserService;
import com.pengxin.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/17 20:46
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(@RequestBody  UserVo userVo) {
        //使用PageHelper.startPag(总共页数,当前页码大小)
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> userByPage = userMapper.findAllUserByPage(userVo);
        PageInfo<User> pageInfo = new PageInfo<>(userByPage);
        return pageInfo;
    }

    @Override
    public void updateUserStatus(Integer id, String status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        Date date = new Date();
        user.setUpdate_time(date);
        userMapper.updateUserStatus(user);

    }
        /*用户登录
        * */
    @Override
    public User login(User user) throws Exception {
        User user1 = new User();
        if (user1!=null&&
                Md5.verify(user.getPassword(),"lagou",user1.getPassword())){
            return user1;
        }else{
            return null;
        }

    }

    @Override
    public List<Role> findRolesById(Integer id) {
        return userMapper.findRolesById(id);
    }
    /*用户关联信息
    * */
    @Override
    public void userContextRole(UserVo userVo) {
        //1、先清空关系的中间表
        userMapper.deleteUserContextRole(userVo.getUserId());
        //封装数据
        for (Integer roleid : userVo.getRoleIdList()) {
            User_Role_relation user_role_relation = new User_Role_relation();

            user_role_relation.setUserId(userVo.getUserId());

            user_role_relation.setRoleId(roleid);
            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");
          //2、再向中间表添加数据
            userMapper.adduserContextRole(user_role_relation);
        }

    }

    @Override
    public ResponseResult getUserPermissions(Integer id) {
        //1.获取当前用户拥有的角色
        List<Role> roleList = userMapper.findRolesById(id);

//2.获取角色ID,保存到 list
        List<Integer> list = new ArrayList<>();


        for (Role role : roleList) { 
            list.add(role.getId());

        }
        //3.根据角色id查询 父菜单
        userMapper.findParentMenuByRoleId(list)
        for (Menu menu :parentMenu) {
            List<Menu> subMenu = userMapper.findSubMenuByPid(menu.getId()); menu.setSubMenuList(subMenu);
        }

    //5.获取资源权限
        List<Resource> resourceList = userMapper.findResourceByRoleId(list);
        //6.封装数据
        Map<String,Object> map = new HashMap<>(); map.put("menuList",parentMenu);	//menuList: 菜单权限数据
        map.put("resourceList",resourceList);//resourceList: 资源权限数据

        ResponseResult result = new ResponseResult(true,200,"响应成功",map); return result;
    }
}
