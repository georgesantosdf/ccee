package com.java.ccce.entidade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Agent {
	@Id
	private Long code;

	@Column(name = "date")
	private String date;

	@OneToMany(cascade = CascadeType.ALL)
	@Column(name = "regions")
	private List<Region> regions;
}
