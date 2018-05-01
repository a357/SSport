package com.smartsport.demo.order.service.impl;

import com.smartsport.demo.domain.Order;
import com.smartsport.demo.domain.Requirements;
import com.smartsport.demo.order.service.OrderService;
import com.smartsport.demo.order.repository.OrderRepository;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class OrderServiceImpl implements OrderService {

    private OrderRepository repository;
    private static DataFactory dataFactory;

    @Autowired
    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
        dataFactory = new DataFactory();
    }

    @Override
    public Order addOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public Order getOrder(String id) {
        return repository.findById(id).get();
    }

    @Override
    public Order updateOrder(Order order) {
        return repository.save(order);
    }

    @Override
    public void deleteOrder(String id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<Order> getAllOrder() {
        return repository.findAll(new Sort(Sort.Direction.ASC,"country", "managerName"));
    }

    @Override
    public Order generateOrder() {
        Requirements requirements = new Requirements();
        requirements.setTrainings(dataFactory.getItem(Arrays.asList(Boolean.TRUE, Boolean.FALSE)));
        requirements.setSauna(dataFactory.getItem(Arrays.asList(Boolean.TRUE, Boolean.FALSE)));
        requirements.setGym(dataFactory.getItem(Arrays.asList(Boolean.TRUE, Boolean.FALSE)));
        requirements.setNumberOfTrainingsSession(dataFactory.getNumberBetween(1,100));

        Order order = new Order();
        order.setRequirements(requirements);
        order.setManagerName(dataFactory.getName());
        order.setNumberOfAthlets(dataFactory.getNumberBetween(1,100));
        order.setStatus(dataFactory.getItem(Arrays.asList(
                "PENDING",
                "COMPLETED",
                "BOOKING",
                "DECLINE")));
        order.setCountry(dataFactory.getItem(Arrays.asList(
                "Australia",
                "Belize",
                "Canada",
                "Faroe Islands",
                "Japan",
                "New Zealand",
                "Niue",
                "Oman",
                "Montenegro",
                "Mali",
                "Malaysia",
                "Ireland",
                "Hungary",
                "Grenada",
                "Jordan",
                "Mexico",
                "Morocco",
                "Nepal",
                "Norway",
                "Qatar",
                "Finland")));
        order.setOrganization(dataFactory.getItem(Arrays.asList(
                "Club",
                "Swimming pool",
                "Stadium",
                "Tennis court")));
        return order;
    }
}
