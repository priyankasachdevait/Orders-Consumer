package com.assignment.consumer.controller;

import com.assignment.consumer.dto.OrderDto;
import com.assignment.consumer.dto.OrderItemDto;
import com.assignment.consumer.service.OrderCallerService;
import com.assignment.consumer.service.OrderItemCallerService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

public class OrderControllerClient {

  @Autowired
  private OrderCallerService orderCallerService;

  @Autowired
  private OrderItemCallerService orderItemCallerService;

  public void getOrder() {
      ResponseEntity<List<OrderDto>> orders = orderCallerService.findAll();
      System.out.println("Orders ====" + orders.getBody());

      final OrderDto fetchedOrder = orders.getBody().get(1);
      fetchedOrder.setCustomerName("Priyanka Test");
      orderCallerService.saveOrder(fetchedOrder);

      ResponseEntity<List<OrderItemDto>> orderItem = orderItemCallerService.findAllOrderItem();
      System.out.println("Order Items ========" + orderItem.getBody());

      final OrderItemDto fetchedOrderItem = orderItem.getBody().get(1);
      fetchedOrderItem.setProductName("Product Test");
      orderItemCallerService.saveOrderItem(fetchedOrderItem);
  }
}
