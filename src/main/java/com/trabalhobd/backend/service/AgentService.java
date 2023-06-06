package com.trabalhobd.backend.service;

import com.trabalhobd.backend.exceptions.EntityNotFoundException;
import com.trabalhobd.backend.model.Agent;
import com.trabalhobd.backend.repository.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AgentService {
    private final AgentRepository agentRepository;

    public AgentService(final AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public Agent createAgent(final Agent agent) {
        return agentRepository.save(agent);
    }

    public List<Agent> getAllAgents() {
        return agentRepository.findAll();
    }

    public Agent getAgentById(final Long agentId) {
        return agentRepository.findById(agentId)
                .orElseThrow(()-> new EntityNotFoundException(Agent.class.toString(),agentId));
    }

    public Agent updateAgent(final Agent agentPutRequest, final Long agentId) {

        return agentRepository.findById(agentId)
                .map(agent -> {
                    final Agent updatedAgent = validateAgentPutRequest(agent, agentPutRequest);
                    return agentRepository.save(updatedAgent);
                }).orElseThrow(()-> new EntityNotFoundException(Agent.class.getName(),agentId));
    }

    public String deleteAgent(final Long agentId) {
        if(!agentRepository.existsById(agentId)){
            throw new EntityNotFoundException(Agent.class.getName(),agentId);
        }
        agentRepository.deleteById(agentId);
        return "Agent with id " + agentId + " was deleted successfully";
    }


    private Agent validateAgentPutRequest(final Agent existingAgent, final Agent agentPutRequest) {
        if(!Objects.isNull(agentPutRequest.getName()) && !agentPutRequest.getName().isEmpty()) {
            existingAgent.setName(agentPutRequest.getName());
        }
        if(!Objects.isNull(agentPutRequest.getVersion()) && !agentPutRequest.getVersion().isEmpty()) {
            existingAgent.setVersion(agentPutRequest.getVersion());
        }
        if(!Objects.isNull(agentPutRequest.getAgentOrigin()) && !agentPutRequest.getAgentOrigin().isEmpty()) {
            existingAgent.setAgentOrigin(agentPutRequest.getAgentOrigin());
        }
        return existingAgent;
    }
}
