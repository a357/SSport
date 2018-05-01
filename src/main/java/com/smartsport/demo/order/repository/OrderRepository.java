package com.smartsport.demo.order.repository;

import com.smartsport.demo.domain.Order;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OrderRepository extends PagingAndSortingRepository<Order, String> {}
