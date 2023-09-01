package com.java.ccce.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@XmlRootElement(name = "agentes")
public class AgentListDTO {
	private List<AgentDTO> agente;
}
