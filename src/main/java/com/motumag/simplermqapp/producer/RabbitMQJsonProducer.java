package com.motumag.simplermqapp.producer;

import com.motumag.simplermqapp.dto.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author: Motuma Gishu, Senior Software Engineer
 * Date: 2/16/25
 * Description: this is for json serilization messages
 */
@Service
@RequiredArgsConstructor
public class RabbitMQJsonProducer {
    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.exchange.name}")
    String topicExchangeName;

    @Value("${rabbitmq.jsonRouting.name}")
    String jsonRoutingName;

    private static final Logger LOGGER= LoggerFactory.getLogger(RabbitMQJsonProducer.class);

    public void sendJsonMessage(User user) {
        LOGGER.info("Sending message to RabbitMQ: {}", user.toString());
        rabbitTemplate.convertAndSend(topicExchangeName, jsonRoutingName, user);
    }
}
