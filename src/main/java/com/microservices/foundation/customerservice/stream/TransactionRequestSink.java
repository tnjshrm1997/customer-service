package com.microservices.foundation.customerservice.stream;


import com.microservices.foundation.customerservice.service.CustomerAccountService;
import com.microservices.foundation.transactionservice.model.CustomerTransactionDetailQueueResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding({Sink.class})
public class TransactionRequestSink {
    final CustomerAccountService accountService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionRequestSink.class);

    public TransactionRequestSink(CustomerAccountService accountService) {
        this.accountService = accountService;
    }

    @StreamListener(target = Sink.INPUT)
    public void updateTransaction(CustomerTransactionDetailQueueResource transactionDetail){

        LOGGER.info("Received message from transaction-service [{}]", transactionDetail);
        if(transactionDetail!=null)
            accountService.updateCustomerAccount(transactionDetail);
    }
}
