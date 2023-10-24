package com.turkcell.productservice.services;

import com.turkcell.productservice.dtos.requests.CreateProductRequest;
import com.turkcell.productservice.dtos.responses.CreatedProductResponse;
import com.turkcell.productservice.entities.Product;
import com.turkcell.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService{
    private final ProductRepository productRepository;
    @Override
    public CreatedProductResponse add(CreateProductRequest request) {
        Product product=Product
                .builder()
                .name(request.getName())
                .price(request.getPrice())
                .description(request.getDescription())
                .stock(request.getStock())
                .build();
        //Burası önce save edecek sonra idli halini product gönderecek,güncelleyeck.
       product =productRepository.save(product);

        CreatedProductResponse response=CreatedProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .build();
        return response;
    }
}
