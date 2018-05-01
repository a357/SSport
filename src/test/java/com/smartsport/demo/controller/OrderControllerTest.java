package com.smartsport.demo.controller;

import com.smartsport.demo.domain.Order;
import com.smartsport.demo.order.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static com.smartsport.demo.util.UtilClass.asJsonString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private OrderServiceImpl service;


    @Test
    public void addOrder() throws Exception {
        Order order = new Order();
        given(service.addOrder(order)).willReturn(order);
        mvc.perform(post("/order")
                .content(asJsonString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getOrder() throws Exception {
        String id = "generatedId";
        String expected = "{\"id\":\""+id+"\",\"managerName\":null,\"organization\":null,\"numberOfAthlets\":null,\"requirements\":null,\"country\":null,\"status\":null}";
        Order order = new Order();
        order.setId(id);
        given(service.getOrder(id)).willReturn(order);
        mvc.perform(get("/order/"+id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    public void updateOrder() throws Exception {
        Order order = new Order();
        given(service.updateOrder(order)).willReturn(order);
        mvc.perform(put("/order")
                .content(asJsonString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllOrder() throws Exception {
        Order order = new Order();
        order.setId("id");
        Iterable orders = Arrays.asList(order);

        given(service.getAllOrder()).willReturn(orders);
        mvc.perform(get("/order/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id",is(order.getId())));
    }
}