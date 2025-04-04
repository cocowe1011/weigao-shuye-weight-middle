package com.middle.ccs.user.service;

import com.middle.ccs.user.entity.UserInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

/**
 * @classDesc: 业务接口:(UserInfo)
 * @author: makejava
 * @date: 2023-06-27 20:58:12
 * @copyright 作者
 */
public interface UserInfoService {
   
    Integer save (UserInfo userInfo);

    Boolean verifyName(UserInfo userInfo);

    Integer updatePassword(UserInfo userInfo);

    Boolean verifyPassword(UserInfo userInfo);
}
