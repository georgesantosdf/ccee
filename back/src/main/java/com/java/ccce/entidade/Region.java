package com.java.ccce.entidade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE )
	private Long id;

    private String acronym;

    @ManyToOne(cascade = CascadeType.ALL)
    private Purchase purchase;

	@ManyToOne(cascade = CascadeType.ALL)
    private Generation generation;

}
