package com.lxk.mgr.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    /**
     * concurrency 并发消费线程数。
     * @param text
     */
    @JmsListener(destination = "sms.queue", concurrency = "5-10")
    // @JmsListener(destination = "sms.queue")
    public void receiveMsg(String text) {
		log.info(text + "----接收到消息*");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info(text + "----完成消息处理*");
    }
}