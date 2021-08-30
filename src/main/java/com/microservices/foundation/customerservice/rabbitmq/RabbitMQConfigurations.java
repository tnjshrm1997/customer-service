package com.microservices.foundation.customerservice.rabbitmq;

import com.microservices.foundation.transactionservice.model.CustomerTransactionDetailQueueResource;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;
import java.util.Map;


@Profile("rabbit")
@Configuration
public class RabbitMQConfigurations {
    @Bean
    public MessageConverter jsonMessageConverter()
    {
        Jackson2JsonMessageConverter jsonMessageConverter = new Jackson2JsonMessageConverter();
        jsonMessageConverter.setClassMapper(classMapper());
        return jsonMessageConverter;
    }


    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    @Bean
    public DefaultClassMapper classMapper()
    {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setTrustedPackages("*");
        classMapper.setDefaultType(Map.class);
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("com.mindstix.microservices.foundation.transactionservice.model.CustomerTransactionDetailQueueResource", CustomerTransactionDetailQueueResource.class);
        classMapper.setIdClassMapping(idClassMapping);
        return classMapper;
    }

}
