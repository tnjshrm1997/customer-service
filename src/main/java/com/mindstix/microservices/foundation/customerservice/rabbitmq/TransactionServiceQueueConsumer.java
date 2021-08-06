package com.mindstix.microservices.foundation.customerservice.rabbitmq;


import com.mindstix.microservices.foundation.customerservice.service.CustomerAccountService;
import com.mindstix.microservices.foundation.transactionservice.model.CustomerTransactionDetailQueueResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = {"transaction_queue"})
public class TransactionServiceQueueConsumer {
    final CustomerAccountService accountService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceQueueConsumer.class);

    public TransactionServiceQueueConsumer(CustomerAccountService accountService) {
        this.accountService = accountService;
    }

    @RabbitHandler
    public void receiveMessage(CustomerTransactionDetailQueueResource accountTransactions)
    {
        LOGGER.info("Received message from transaction-service [{}]", accountTransactions);
        if(accountTransactions!=null)
            accountService.updateCustomerAccount(accountTransactions);
    }
}
