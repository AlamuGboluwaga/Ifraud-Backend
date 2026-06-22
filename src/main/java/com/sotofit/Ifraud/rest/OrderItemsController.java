package com.sotofit.Ifraud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderItemsController {
    @GetMapping("/orderItems")
    public Object GellAllOrderItems(){
        return "OrderItems";
    }
}
