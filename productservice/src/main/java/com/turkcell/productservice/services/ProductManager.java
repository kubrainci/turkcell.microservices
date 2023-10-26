package com.turkcell.productservice.services;

import com.turkcell.productservice.dtos.requests.CreateProductRequest;
import com.turkcell.productservice.dtos.responses.CreatedProductResponse;
import com.turkcell.productservice.dtos.responses.ResponseForSubmitOrder;
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
                .inventoryCode(request.getInventoryCode())
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

    @Override
    public ResponseForSubmitOrder getByInventoryCode(String code, int requiredStock) {
        Boolean hasStock =true;
        Product product=productRepository.findByInventoryCode(code);
        if (product==null || product.getStock()<requiredStock){
            hasStock=false;

        }
        ResponseForSubmitOrder response =ResponseForSubmitOrder.builder()
                .inventoryCode(product.getInventoryCode())
                .hasStock(hasStock)
                .stockAmount(product.getStock())
                .build();
        return response;

    }






}
