package com.turkcell.productservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(value = "products")
public class Product {
    //idleri string olarak yazıyoruz.
    //column diye işaretlememize gerek yok.
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;

}
