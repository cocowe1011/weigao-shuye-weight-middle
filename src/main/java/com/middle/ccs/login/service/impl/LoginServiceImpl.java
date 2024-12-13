package com.middle.ccs.login.service.impl;

import com.middle.ccs.hander.BusinessException;
import com.middle.ccs.hander.CommonErrorCode;
import com.middle.ccs.login.dao.LoginServiceMapper;
import com.middle.ccs.login.entity.LoginDTO;
import com.middle.ccs.login.service.LoginService;
import com.middle.ccs.user.dao.UserInfoMapper;
import com.middle.ccs.user.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * 功能描述: (对外提供预约信息的中台接口)
 * @author 文亮
 * @since 2022年5月13日14:07:01
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginServiceMapper loginServiceMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 登录
     * @param loginDTO 登录入参
     * @return 登录出参
     */
    @Override
    public UserInfo login(LoginDTO loginDTO) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserCode(loginDTO.getUserCode());
        // 通过userCode去查询密码
        List<UserInfo> entity =  userInfoMapper.selectUserList(userInfo);
        if(entity.size() != 1) {
            throw BusinessException.build(CommonErrorCode.NOT_EXITS_USER_CODE);
        }
        // 验证密码是否正确 PASSWORD_ERROR
        if(!(null != loginDTO.getUserPassword() && loginDTO.getUserPassword().equals(entity.get(0).getUserPassword()))) {
            throw BusinessException.build(CommonErrorCode.PASSWORD_ERROR);
        }
        return entity.get(0);
    }
}
