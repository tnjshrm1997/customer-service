# Customer Service (Microservice Foundation)


## Introduction

To maintain customer account data, this service interacts with a MySQL database. It has two primary functions:
1. Creation a new customer account
2. Manage the transactions of an existing customer's account.

## Implementation and Functionality

Let's discuss them by taking developed API's for this service. 

1. `POST /customer-service/customer/` : This request is for the creation of a new customer account.
2. `GET /customer-service/customer/{emailId}` : This request will provide information on the customer's account, including the account number and current balance. 
3. `GET /customer-service/account/{emailId}` : This request is utilised by our second service, `transaction-service`, to retrieve information about the customer's present in our system and return accountNumber for processing by `transaction-service`.
4. We use the AMQP Protocol to process and update customer transactions. Transaction Service will send transaction data to RabbitMQ exchange and it will route to transaction-queue. Customer Service is listening to this queue and will consume the information in order to update the database.
5. `GET /customer-service/account/amount/{amount}` : This request will try to get information on all customers with a balance larger than the specified amount. This request was created to try the stream and map implementation.


