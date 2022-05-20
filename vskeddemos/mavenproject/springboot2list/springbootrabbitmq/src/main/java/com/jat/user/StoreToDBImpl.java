package com.jat.user;

import com.jat.config.ProjectConfig;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class StoreToDBImpl {
    private static final Logger logger = LoggerFactory.getLogger(StoreToDBImpl.class);
    @Autowired
    StringRedisTemplate redisTemplate;

    String saveFlag="db_savec";

    @RabbitListener(queues = ProjectConfig.DB_QUEUE_NAME)
    public void consume(Message message, Channel channel) throws IOException {
        User user = (User) message.getPayload();
        MessageHeaders headers = message.getHeaders();
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        String msgId = (String) headers.get("spring_returned_message_correlation");
        if (redisTemplate.opsForHash().entries(saveFlag).containsKey(msgId)) {
            //redis 中包含该 key，说明该消息已经被消费过
            logger.info(msgId + ":消息已经被消费");
            channel.basicAck(tag, false);//确认消息已消费
            return;
        }
        //收到消息，存储到数据库
        try {
            redisTemplate.opsForHash().put(saveFlag, msgId, "save user to DB success:"+user);
            channel.basicAck(tag, false);
            logger.info(msgId + ":用户保存到数据库成功"+user);
        } catch (MessagingException e) {
            channel.basicNack(tag, false, true);
            e.printStackTrace();
            logger.error("用户保存到数据库失败：" + e.getMessage()+""+user);
        }
    }
}
