package com.v5ba.rabbitmq.demo;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.rabbitmq.tools.json.JSONUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("sender1")
    public String sender1(){
        amqpTemplate.convertAndSend(Constant.EXCHANGE_01, Constant.ROUTING_KEY_01_01, "张三");
        return "ok";
    }
    @GetMapping("sender2")
    public String sender2(){
        User user = new User();
        user.setName("神坑");
        user.setId(1L);
        user.setAge(30);
        amqpTemplate.convertAndSend(Constant.EXCHANGE_01, Constant.ROUTING_KEY_01_02, JSONObject.toJSONString(user));
        return "ok";
    }
}
