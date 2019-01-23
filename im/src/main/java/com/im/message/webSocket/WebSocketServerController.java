package com.im.message.webSocket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author JialinLiu
 * @date 2018/9/7 0007 15:01
 */
@RestController
@RequestMapping("api/ws")
public class WebSocketServerController {
    //@GetMapping("sendAll")
    @RequestMapping(value="/sendAll", method=RequestMethod.GET)
    /**
     * 群发消息内容
     * @param message
     * @return
     */
    String sendAllMessage(@RequestParam(required=true) String message){
        try {
            WebSocketServer.broadCastInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
    //@GetMapping("sendOne")
    @RequestMapping(value="/sendOne", method=RequestMethod.GET)
    /**
     * 指定会话ID发消息
     * @param message 消息内容
     * @param id 连接会话ID
     * @return
     */
    String sendOneMessage(@RequestParam(required=true) String message, @RequestParam(required=true) String id){
        try {
            WebSocketServer.sendMessage(id,message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
