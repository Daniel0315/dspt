package com.neuedu.dao;

import com.neuedu.entity.Authority;

import java.util.List;

public interface AuthorityDao {

    /**
     * 查询权限
     * @return
     */
    List<Authority> listAuthority(List<String> ids);

    /**
     * 遍历权限
     */
    List<Authority> authority();
}
