package com.ultrapower.web.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(Object message){
        System.out.println("消息发布者");

        amqpTemplate.convertAndSend("queueTestKey",message);
    }
}
