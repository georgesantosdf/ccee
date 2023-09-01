package com.java.ccce.entidade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
public class Generation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	private Long id;

	@ElementCollection
	@CollectionTable(name="generation_value")
	private List<BigDecimal> generationValue;
}
