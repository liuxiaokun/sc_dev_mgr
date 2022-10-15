package com.lxk.mgr.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

@Component
@Slf4j
public class Producer {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue queue;

    public void sendMsg(String msg) {
        for (int i = 0; i < 100; i++) {
            jmsMessagingTemplate.convertAndSend(this.queue, i);
            log.info("生产者发送消息内容:{}", i);
        }
    }
}
