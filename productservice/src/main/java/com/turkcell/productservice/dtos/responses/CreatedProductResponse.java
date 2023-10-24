package com.turkcell.productservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CreatedProductResponse {
    //Burası product ile aynı veri tabanı dökümanını kullanmamak için kendime has bir class oluşturuyorum.
    private String id;
    private String name;

}
