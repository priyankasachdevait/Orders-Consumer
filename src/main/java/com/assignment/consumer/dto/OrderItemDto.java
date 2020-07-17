package com.assignment.consumer.dto;

import java.util.Date;
import lombok.Data;

@Data
public class OrderItemDto {

  private String productCode;
  private String productName;
  private int quantity;
  private Long orderId;
}
