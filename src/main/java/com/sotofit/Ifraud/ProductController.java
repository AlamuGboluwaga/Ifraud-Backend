package com.sotofit.Ifraud;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Entity
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {


}
