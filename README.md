## Rewards-Calculator-Restful
### `Rest API / Spring boot with spring security`

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.   
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction  (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).   
Given a record of every transaction during a three month period, calculate the reward points earned for each customer per month and total.

- Make up a data set to best demonstrate the solution
- Make the application secured with API keys
- Check solution into GitHub



#### `Instructions for running the project on a local machine:`

$ git clone https://github.com/sreerangaravindhrainukonda/rewards-service.git

$ mvn spring-boot: run

$ send X-API-KEY in header to authenticate the request

$ `curl --location 'http://localhost:8080/api/customers/100' \
--header 'X-API-KEY: test123'`

$ `curl --location 'http://localhost:8080/api/customers' \
--header 'X-API-KEY: test123'`
