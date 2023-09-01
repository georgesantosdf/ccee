package com.java.ccce.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@XmlRootElement(name = "agente")
public class AgentDTO {
	private Long codigo;

	private String data;

	private List<RegionDTO> regiao;
}
