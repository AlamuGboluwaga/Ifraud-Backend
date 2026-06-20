package com.sotofit.Ifraud.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GetAllController {
@GetMapping("/")
public String GetAll(){
    return "Hello World";
}
}
