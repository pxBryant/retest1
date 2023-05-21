package com.pengxin.controller;

import com.github.pagehelper.PageInfo;
import com.pengxin.pojo.ResponseResult;
import com.pengxin.pojo.Role;
import com.pengxin.pojo.User;
import com.pengxin.pojo.UserVo;
import com.pengxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Bryant
 * @create 2023/5/17 20:49
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(UserVo userVo) {
        PageInfo userByPage = userService.findAllUserByPage(userVo);
        ResponseResult result = new ResponseResult(true, 200, "用户分页查询成功", userByPage);
        return result;
    }

    /*
     * 更新用户状态信息
     * */
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(Integer id, String status) {
        userService.updateUserStatus(id, status);
        ResponseResult result = new ResponseResult(true, 200, "用户更新成功", null);
        return result;
    }

    /*
     * 用户登录
     * */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        User user1 = userService.login(user);
        if (user1 != null) {
            Map<String, Object> map = new HashMap<>();
            String access_token = UUID.randomUUID().toString();
            map.put("access_token", access_token);
            map.put("user_id", user1.getId());
            HttpSession session = request.getSession();
            session.setAttribute("user_id", user1.getId());
            session.setAttribute("access_token", access_token);
            return new ResponseResult(true, 200, "用户登录成功", map);
        }
        return new ResponseResult(true, 500, "用户账号密码错误", null);
    }

    /*
     * 根据id号实现查询当前用户当前角色
     * */
    @RequestMapping("/findRolesById")
    public ResponseResult findRolesById(Integer id) {
        List<Role> roles = userService.findRolesById(id);
        return new ResponseResult(true, 200, "id号实现查询当前用户当前角色成功", roles);
    }

    /*
     * 分配角色
     * */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo) {
        userService.userContextRole(userVo);
        return new ResponseResult(true, 200, "分配角色成功", null);
    }

    /**
     * 获取用户权限
     */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request) {

//获取请求头中的 token
        String token = request.getHeader("Authorization");

//获取session中的access_token
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");

//判断
if(token.equals(access_token)){
        int user_id = (Integer) session.getAttribute("user_id");
        ResponseResult result = userService.getUserPermissions(user_id);
        return result;
    }else{
        ResponseResult result = new ResponseResult(false, 400, "获取失败", "");
        return result;
    }
}

}
