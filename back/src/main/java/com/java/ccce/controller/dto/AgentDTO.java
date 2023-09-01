package com.java.ccce.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AgentDTO {
	@JsonProperty("codigo")
	private Long code;

	@JsonProperty("data")
	private String date;

	@JsonProperty("regioes")
	private List<RegionDTO> regions;
}
