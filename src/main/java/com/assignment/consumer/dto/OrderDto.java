package com.assignment.consumer.dto;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class OrderDto {

  private String customerName;
  private Date orderDate;
  private String shippingAddress;
  private List<OrderItemDto> orderItems;
  private BigDecimal total;

}
