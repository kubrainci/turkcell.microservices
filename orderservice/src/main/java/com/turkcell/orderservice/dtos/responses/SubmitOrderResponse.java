package com.turkcell.orderservice.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class SubmitOrderResponse {
    private String inventoryCode;
    private Boolean hasStock;
    private int stockAmount;
}
