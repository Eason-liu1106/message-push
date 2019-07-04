package com.login.service;

import com.login.model.vo.TbUser;

/**
 * @author JialinLiu
 * @date 2019/7/4 0004 15:03
 */
public interface UserService {
    /**
     * 统一验证登录中心
     *
     * @param username 用户名
     * @return
     * @author JialinLiu
     * @date
     */
    TbUser login(String username, String password);
}
