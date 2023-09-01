package com.java.ccce.controller;

import com.java.ccce.dto.AgentDTO;
import com.java.ccce.dto.AgentListDTO;
import com.java.ccce.entidade.Agent;
import com.java.ccce.service.AgentService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.net.URISyntaxException;

@SpringBootTest
class AgentControllerTests {

	@Autowired
	private AgentService agentService;

	@Autowired
	private ModelMapper mapper;

	//@Test
	void testSave() throws JAXBException, URISyntaxException {
		JAXBContext jaxbContext = JAXBContext.newInstance(AgentListDTO.class);

		// Crie o unmarshaller
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		String nomeArquivo = "exemplo_01.xml";
		ClassLoader classLoader = AgentControllerTests.class.getClassLoader();

		File xmlFile = new File(classLoader.getResource(nomeArquivo).toURI());

		// Realize o mapeamento do XML para objetos DTO
		AgentListDTO agentListDTO = (AgentListDTO) unmarshaller.unmarshal(xmlFile);
		for (AgentDTO agentDTO: agentListDTO.getAgente()) {
			agentService.save(mapper.map(agentDTO, Agent.class));
		}
	}

}
