package com.java.ccce.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PurchaseDTO {
	  @JsonProperty("valor")
	  private List<BigDecimal> purchaseValue;
}
