package com.java.ccce.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegionDTO {
    @JsonProperty("sigla")
    private String acronym;

    @JsonProperty("compra")
    private PurchaseDTO purchase;

    @JsonProperty("geracao")
    private GenerationDTO generation;

    @JsonProperty("precoMedio")
    private AveragePriceDTO averagePrice;
}
