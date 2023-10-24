package com.turkcell.productservice.services;

import com.turkcell.productservice.dtos.requests.CreateProductRequest;
import com.turkcell.productservice.dtos.responses.CreatedProductResponse;

public interface ProductService {
    CreatedProductResponse add(CreateProductRequest request);
}
