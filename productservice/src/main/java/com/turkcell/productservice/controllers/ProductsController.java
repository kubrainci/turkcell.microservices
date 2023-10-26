package com.turkcell.productservice.controllers;

import com.turkcell.productservice.dtos.requests.CreateProductRequest;
import com.turkcell.productservice.dtos.responses.CreatedProductResponse;
import com.turkcell.productservice.dtos.responses.ResponseForSubmitOrder;
import com.turkcell.productservice.entities.Product;
import com.turkcell.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse add(@RequestBody CreateProductRequest request){

        return productService.add(request);
    }

    /*@GetMapping("getByInventoryCode")
    public Product findByInventoryCode(String inventoryCode){
        return productService.getByInventoryCode(inventoryCode);
    }*/

    @GetMapping("check-stock")
    public ResponseForSubmitOrder getByInventoryCode(@RequestParam String invCode,
                                                     @RequestParam int amount){
        return productService.getByInventoryCode(invCode,amount);
    }
}
