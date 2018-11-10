package com.neuedu.dao;

import com.neuedu.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * 便利用户账号
     */
    List<User> listUname();

    /**
     * 查询vip用户信息
     */
    List<User> listUser(Integer rlevel,Integer offset,Integer num);

    /**
     * 分页
     * @param rlevel
     * @return
     */
   int sumCount(Integer rlevel);


    /**
     * 删除vip用户信息
     */
    int deleteUser(String uname);

    /**
     * 通过账户查找信息
     * 修改个人信息和通过输入框查找个人信息
     */
    List<User> listUserByUname(String uname);

    /**
     * 修改vip用户信息
     *
     */
    int updateUser(User user);

    /**
     * 登录
     */
    User login(String uname,String upwd);

    /**
     * 注册账号
     * @param
     *
     * @return
     */
    int register(String uname,String upwd,String uemail,String uphone);

    /**
     * 根据账号去分配权限
     */
    int distribution(String uname,String raids);

    /**
     * 注册校验用户名
     */
    User checkUname(String uname);
}
