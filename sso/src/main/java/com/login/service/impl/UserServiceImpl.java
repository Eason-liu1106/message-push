package com.login.service.impl;

import com.login.model.vo.TbUser;
import com.login.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author JialinLiu
 * @date 2019/7/4 0004 15:04
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * 统一验证登录中心
     *
     * @param username 用户名
     * @param password 密码
     * @return
     * @author JialinLiu
     * @date
     */
    @Override
    public TbUser login(String username, String password) {
        return null;
    }
}
