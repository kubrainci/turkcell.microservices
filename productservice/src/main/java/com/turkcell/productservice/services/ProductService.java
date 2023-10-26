package com.turkcell.productservice.services;

import com.turkcell.productservice.dtos.requests.CreateProductRequest;
import com.turkcell.productservice.dtos.responses.CreatedProductResponse;
import com.turkcell.productservice.dtos.responses.ResponseForSubmitOrder;
import com.turkcell.productservice.entities.Product;

public interface ProductService {
    CreatedProductResponse add(CreateProductRequest request);
   /* Product getByInventoryCode(String code);*/
   ResponseForSubmitOrder getByInventoryCode(String code, int requiredStock);
   /*  Product getByrequiredStock(String code,int requiredStock);*/

}
