package com.sotofit.Ifraud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
@GetMapping("/products")
    public Object GellAllProducts(){
        return "prodcuts" ;

    }
}
