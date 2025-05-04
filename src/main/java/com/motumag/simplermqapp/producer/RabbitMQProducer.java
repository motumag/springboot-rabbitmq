package com.motumag.simplermqapp.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Author: Motuma Gishu, Senior Software Engineer
 * Date: 2/16/25
 * Description: This is the service class for the publisher
 */
@Service
public class RabbitMQProducer {
    private static final Logger logger= LoggerFactory.getLogger(RabbitMQProducer.class);

    @Value("${rabbitmq.exchange.name}")
    String topicExchangeName;

    @Value("${rabbitmq.routing.name}")
    String routingKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void sendMessage(String message) {
        logger.info("Sending message: " + message);
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, message);
    }
}
