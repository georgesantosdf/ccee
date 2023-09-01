package com.java.ccce.controller;


import com.java.ccce.controller.dto.AgentDTO;
import com.java.ccce.entidade.Agent;
import com.java.ccce.service.AgentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/agentes")
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	@Autowired
	private ModelMapper mapper;
		
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public AgentDTO save(@RequestBody AgentDTO agentDTO) {
        agentService.save(mapper.map(agentDTO, Agent.class));
        return agentDTO;
    }
    
    @GetMapping("/regiao/{regiao}")
    public List<AgentDTO> agentesPost(@PathVariable String regiao) {
        return agentService.findByRegionAcronym(regiao)
                .stream()
                .map(agent -> mapper.map(agent, AgentDTO.class))
                .collect(Collectors.toList());
    }

}
