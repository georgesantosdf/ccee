package com.java.ccce.service;

import com.java.ccce.entidade.Agent;
import com.java.ccce.repository.AgentRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class AgentService {
	
	private final AgentRepository agentRepository;
	public Agent save(Agent agent) {
		if (Objects.nonNull(agent)) {
			return agentRepository.save(agent);
		}
		return null;
	}
	
	public List<Agent> findByRegionAcronym(String region) {
		if (Objects.nonNull(region)) {
			return agentRepository.findByRegionsAcronym(region);
		}
		return Collections.emptyList();
	}
}
