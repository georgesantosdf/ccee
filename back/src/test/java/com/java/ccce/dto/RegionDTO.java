package com.java.ccce.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "regiao")
public class RegionDTO {
    @XmlElement(name = "sigla")
    private String sigla;

    @XmlElement(name = "compra")
    private PurchaseDTO compra;

    @XmlElement(name = "geracao")
    private GenerationDTO geracao;

    @XmlElement(name = "precoMedio")
    private AveragePriceDTO precoMedio;
}
