package com.v5ba.rabbitmq.demo;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "log-queue2")
public class LogQueue2Listener {

    @RabbitHandler
    public void process(String message){
        User user = JSONObject.parseObject(message, User.class);
        System.out.println("监听二, 消息内容:"+ user.getName()+"--"+user.getAge());
    }
}
