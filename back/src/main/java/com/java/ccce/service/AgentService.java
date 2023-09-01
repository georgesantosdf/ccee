package com.java.ccce.service;

import com.java.ccce.entidade.Agent;
import com.java.ccce.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AgentService {
	
	private final AgentRepository agentRepository;
	public Agent save(Agent agent) {
		return agentRepository.save(agent);
	}
	
	public List<Agent> findByRegionAcronym(String region) {
		return agentRepository.findByRegionsAcronym(region);
	}
}
