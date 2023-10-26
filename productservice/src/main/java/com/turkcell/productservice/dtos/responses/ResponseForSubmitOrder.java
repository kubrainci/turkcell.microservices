package com.turkcell.productservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ResponseForSubmitOrder {
    private String inventoryCode;
    private Boolean hasStock;
    private int stockAmount;

}
