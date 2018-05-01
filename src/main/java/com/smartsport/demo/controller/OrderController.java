package com.smartsport.demo.controller;

import com.smartsport.demo.domain.Order;
import com.smartsport.demo.order.service.OrderService;
import com.smartsport.demo.order.service.impl.OrderServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@Api(value="order", description="Operations with order")
public class OrderController {

    private OrderService service;

    public OrderController(OrderServiceImpl service) {
        this.service = service;
    }

    @ApiOperation(value = "addOrder", notes = "Add order", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully add order"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping
    public ResponseEntity<Order> addOrder(@RequestBody Order order){
        return new ResponseEntity(service.addOrder(order), HttpStatus.OK);
    }

    @ApiOperation(value = "getOrder", notes = "Get order", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get order"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id")String id){
        return new ResponseEntity(service.getOrder(id), HttpStatus.OK);
    }

    @ApiOperation(value = "updateOrder", notes = "Update order", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully update order"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PutMapping
    public ResponseEntity<Order> updateOrder(@RequestBody Order order){
        return new ResponseEntity(service.updateOrder(order), HttpStatus.OK);
    }

    @ApiOperation(value = "deleteOrder", notes = "Delete order", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully delete order"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable("id")String id){
        try{
            service.deleteOrder(id);
            return new ResponseEntity("Order deleted successfully", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "getAllOrder", notes = "get all order", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully get all orders"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/list")
    public Iterable<Order> getAllOrder(){
        return service.getAllOrder();
    }

    @ApiOperation(value = "generateOrder", notes = "generate order", response = Order.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully generate order"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @GetMapping("/generateOrder")
    public Order generateOrder(){
        return service.generateOrder();
    }

}
