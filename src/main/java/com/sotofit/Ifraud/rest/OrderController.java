package com.sotofit.Ifraud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
@GetMapping("/order")
    public Object GellAllOrder(){
        return "Order";
    }

}
