package com.login.web;

import com.login.model.vo.TbUser;
import com.login.service.UserService;
import common.argument.result.ResultEnity;
import common.util.JwtUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 登录控制器
 *
 * @author JialinLiu
 * @date 2019/7/4 0004 10:14
 */
@RestController("api/login")
public class LoginController {
    private static final Log log = LogFactory.getLog(LoginController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    private JedisPool jedisPool = new JedisPool();

    @PostMapping
    public ResultEnity login() {
        return new ResultEnity();
    }

    /**
     * 统一验证登录中心
     *
     * @param username 用户名
     * @param password 密码
     */
    @PostMapping
    public void checkLogin(String username, String password, String returnUrl, HttpServletResponse response) {
        TbUser user = userService.login(username, password);
        log.info("user: " + user);
        String jwtValue = null;
        if (user != null) {
            /*
             * 获得uuid,作为tokenId（TGC）
             * 将tokenId存进jedis，返回客户端以jwt存储的tokenId，
             * 即使tokenId被截取也无所谓
             */
            String tokenId = UUID.randomUUID().toString();
            //生成jwt
            jwtValue = new JwtUtil(tokenId, null).creatJwt();
            log.info("tokenId: " + tokenId + " jwt: " + jwtValue);
            if (jwtValue != null) {
                Jedis jedis = jedisPool.getResource();
                redisTemplate.opsForValue().set(tokenId, user.toString());
                jedis.set(tokenId, user.toString());
                jedis.expire(tokenId, 1800);
                log.info("查看key的剩余生存时间：" + jedis.ttl(tokenId));
            }
        }
        //将jwt加密的TGC存进cookie
        Cookie cookie = new Cookie("tokenId", jwtValue);
        //设置根域名
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        try {
            response.sendRedirect(returnUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
