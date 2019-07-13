package com.firnas.web.controller;


import com.firnas.web.model.message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Chatcontroller {


    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public message register(@Payload message message, SimpMessageHeaderAccessor headerAccessor){

        headerAccessor.getSessionAttributes().put("username",message.getSender());
        return message;

    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public message sendMessage(@Payload message message){

        return  message;
    }




}
