package com.im.message.webSocket;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.session.StandardSessionFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * 主要的配置类
 *  本类必须要继承Configurator,因为@ServerEndpoint注解中的config属性只接收这个类型
 * @author 侯叶飞
 *
 */
@Configuration
@Slf4j
public class WebsocketConfig extends ServerEndpointConfig.Configurator {
    private static Logger log = LoggerFactory.getLogger(WebsocketConfig.class);

    private static final String HttpSession = null;
    /* 修改握手,就是在握手协议建立之前修改其中携带的内容 */
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        /*如果没有监听器,那么这里获取到的HttpSession是null*/
        StandardSessionFacade ssf = (StandardSessionFacade) request.getHttpSession();
        if (ssf != null) {
            HttpSession session = (HttpSession) request.getHttpSession();
            sec.getUserProperties().put("sessionid", session);
            log.info("获取到的SessionID：{}",session.getId());
        }
        sec.getUserProperties().put("name", "小强");
        super.modifyHandshake(sec, request, response);
    }
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
