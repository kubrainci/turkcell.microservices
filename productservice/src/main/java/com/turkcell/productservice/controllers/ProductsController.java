package com.turkcell.productservice.controllers;

import com.turkcell.productservice.dtos.requests.CreateProductRequest;
import com.turkcell.productservice.dtos.responses.CreatedProductResponse;
import com.turkcell.productservice.dtos.responses.ResponseForSubmitOrder;
import com.turkcell.productservice.entities.Product;
import com.turkcell.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;
    private final KafkaTemplate kafkaTemplate;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@RequestBody CreateProductRequest request){

        return productService.add(request);
    }



    @GetMapping("check-stock")
    public ResponseForSubmitOrder getByInventoryCode(@RequestParam String invCode,
                                                     @RequestParam int amount){
        kafkaTemplate.send("notificationTopic", "Şipariş verildi.");
        return productService.getByInventoryCode(invCode,amount);
    }

    @GetMapping("deneme")
    public String deneme(){
        return "Deneme";
    }
}
