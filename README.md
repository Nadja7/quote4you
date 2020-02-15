# quote4you

This service provides you quotes for every day.
Short description for each service:

1.Config Server: 

Spring Boot App with  provides a server support for clients  to store their configurations and manage external properties.
Config remote repository with all properties are here --> [quote4you-config](https://github.com/Nadja7/quote4you-config/).

2.Discovery Service

Eureka Dashboard is available on:

```bash
http://localhost:8761/
```

3.Quote-Service:

Spring Boot App which contains,persist  data and expose some endpoints for other services.
```bash
http://localhost:8081/
Get all quotes
```
```bash
http://localhost:8081/{id}
Get quote with specific id.
```
 
4.Day-Service:

Spring Boot App which makes a API call to Quote Service using Feign Client and print back random quote. 
Check it out on:
```bash
http://localhost:8085/
```
5.Converting Service:

Spring Boot App which converts all Quotes from Quote-Service and packs it to txt.file.
Check it out on:
```bash
http://localhost:8083/
```

All microservices are Spring Boot Apps. 

To start working with this service you need to run it in following sequence :


1.Run ConfigServer Application 

There are following endpoints to get properties for each services:

Eureka Server

```bash
http://localhost:8888/discovery-service/default
```

Day-Service

```bash
http://localhost:8888/day-service/default
```

Quote-Service

```bash
http://localhost:8888/quote-service/default
```

Converting-Service

```bash
http://localhost:8888/converting-service/default
```


2.Run DiscoveryService Application

!!!To persist data we are using MySQL as Docker image.!!!

Pull mysql docker image and run your container with following command:

```bash
docker run -e MYSQL_ROOT_PASSWORD=whatever -e MYSQL_USER=spring -e MYSQL_PASSWORD=whatever -e MYSQL_DATABASE=QuoteDb  --name mysql --publish 3306:3306 mysql
```

4.Run QuoteService Application

5.Run DayService Application

6.Run ConvertingService Application

There are also try to protect Day Service and also Converting Service using Spring @Retry and Fallback class wenn Quote Service is for some reason down.
In this case services will continue to  work with default values.
