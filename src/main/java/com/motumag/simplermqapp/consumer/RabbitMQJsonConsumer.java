package com.motumag.simplermqapp.consumer;

import com.motumag.simplermqapp.dto.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Author: Motuma Gishu, Senior Software Engineer
 * Date: 2/16/25
 * Description: This is for the consumer part
 */
@Service
@RequiredArgsConstructor
public class RabbitMQJsonConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQJsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.jsonQueue.name}"})
    public void consumeJson(User user) {
        LOGGER.info("Consuming json message: {}", user.toString());

    }
}
