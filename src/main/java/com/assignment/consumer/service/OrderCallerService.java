package com.assignment.consumer.service;

import com.assignment.consumer.dto.OrderDto;
import com.assignment.consumer.dto.OrderItemDto;
import java.util.List;
import javax.validation.Valid;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="order-producer")
public interface OrderCallerService {

  @RequestMapping(method= RequestMethod.GET, value="/order")
  public ResponseEntity<List<OrderDto>> findAll();

  @RequestMapping(method= RequestMethod.POST, value="/order")
  public ResponseEntity<OrderDto> saveOrder(@RequestBody @Valid final OrderDto orderDto);

}
