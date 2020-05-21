package com.ai.dev.support.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class RocketMQUtil {

    private DefaultMQProducer producer;
    private RocketMQUtil(){}
    private static class Singleton{
        private static RocketMQUtil instance = new RocketMQUtil();
    }
    public static RocketMQUtil getInstance(){
        return Singleton.instance;
    }

    public void init(String producerMqGroupName,String mqNameServer,String mqTopic) throws MQClientException {
        if (producer == null) {
            log.info("===================启动消息队列生产者[开始]==================");
            producer = new DefaultMQProducer(producerMqGroupName);
            producer.setNamesrvAddr(mqNameServer);
            producer.setVipChannelEnabled(false);
            producer.setCreateTopicKey(mqTopic);
            producer.start();
            log.info("消息队列信息为：producerGroup:[{}], namesrvAddr: [{}],TopicKey: [{}] ", producerMqGroupName, mqNameServer, mqTopic);
            log.info("===================启动消息队列生产者[结束]==================");
        }
    }

    public void destroy() {
        if (producer != null) {
            log.info("===================销毁消息队列生产者[开始]==================");
            producer.shutdown();
            log.info("===================销毁消息队列生产者[结束]==================");
        }
    }

    /*public  Map<String, Object> PushTaskInfo(String tag, String sendBody) {
        log.info("===================发送代办消息[开始]==================");
        Map<String, Object> map = new HashMap<>();
        Boolean flage;
        String mgId = "";
        Message message = new Message(AifcsConstant.MQ_TOPICS, tag, sendBody.getBytes());
        producer.setRetryTimesWhenSendAsyncFailed(0);
        producer.setInstanceName(String.valueOf(Calendar.getInstance().getTimeInMillis()) + (1 + Math.random() * 1000));
        // SendCallbackImpl sendCallback = new SendCallbackImpl();
        try {
            // producer.send(message, sendCallback);
            SendResult send = producer.send(message);
            log.info("===================消息==================>{}", send.toString());
            flage = true;
            mgId = send.getMsgId();
            map.put("flage", flage);
            map.put("mgId", mgId);
        } catch (MQClientException | RemotingException | InterruptedException | MQBrokerException e) {
            e.printStackTrace();
        }
        log.info("===================发送代办消息[结束]==================");
        return map;
    }*/
}

