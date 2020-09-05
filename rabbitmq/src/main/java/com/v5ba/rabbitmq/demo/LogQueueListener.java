package com.v5ba.rabbitmq.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "log-queue")
public class LogQueueListener {

    @RabbitHandler
    public void process(String hello){
        System.out.println("监听一,消息内容:"+hello);
    }
}
