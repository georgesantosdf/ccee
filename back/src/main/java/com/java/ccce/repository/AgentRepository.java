package com.java.ccce.repository;
import com.java.ccce.entidade.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AgentRepository extends JpaRepository<Agent, Long>{
	List<Agent> findByRegionsAcronym(String region);
}
