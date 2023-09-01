package com.java.ccce.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@XmlRootElement(name = "compra")
public class PurchaseDTO {
	@XmlElement(name = "valor")
	  private List<BigDecimal> valor;
}
