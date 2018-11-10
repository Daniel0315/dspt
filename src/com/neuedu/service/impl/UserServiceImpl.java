package com.neuedu.service.impl;

import com.neuedu.dao.AuthorityDao;
import com.neuedu.dao.UserDao;
import com.neuedu.dao.impl.AuthorityDaoImpl;
import com.neuedu.dao.impl.UserDaoImpl;
import com.neuedu.entity.Authority;
import com.neuedu.entity.User;
import com.neuedu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> listUname() {
        return userDao.listUname();
    }

    @Override
    public List<User> listUser(Integer rlevel, Integer offset, Integer num) {
        List<User> userList=userDao.listUser(rlevel,offset,num);
        return userList;
    }

    @Override
    public int sumCount(Integer rlevel) {
        return userDao.sumCount(rlevel);
    }

    @Override
    public int deleteUser(String uname) {
        return userDao.deleteUser(uname);
    }

    @Override
    public List<User> listUserByUname(String uname) {
        return userDao.listUserByUname(uname);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User login(String uname, String upwd) {

        return userDao.login(uname,upwd);
    }

    @Override
    public int register(String uname, String upwd, String uemail, String uphone) {
        return userDao.register(uname,upwd,uemail,uphone);
    }

    @Override
    public int distribution(String uname, String raids) {
        return userDao.distribution(uname,raids);
    }

    @Override
    public User checkUname(String uname) {
        return userDao.checkUname(uname);
    }
}
