package com.assignment.consumer;

import com.assignment.consumer.controller.OrderControllerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class OrdersConsumerApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(OrdersConsumerApplication.class, args);
    OrderControllerClient consumerControllerClient = ctx.getBean(OrderControllerClient.class);
    System.out.println(consumerControllerClient);
    consumerControllerClient.getOrder();
  }

  @Bean
  public OrderControllerClient orderControllerClient() {
    return new OrderControllerClient();
  }
}
