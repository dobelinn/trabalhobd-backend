package com.trabalhobd.backend.controller;

import com.trabalhobd.backend.model.Agent;
import com.trabalhobd.backend.service.AgentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("http://localhost:3000")
public class AgentController {
    private final AgentService agentService;

    public AgentController(final AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping("/agent")
    Agent createBluePill(@RequestBody Agent agent) {
        return agentService.createAgent(agent);
    }

    @GetMapping("/agents")
    List<Agent> getAllBluePills() {
        return agentService.getAllAgents();
    }

    @GetMapping("/agent/{agentId}")
    Agent getBluePillById(@PathVariable Long agentId) {
        return agentService.getAgentById(agentId);
    }

    @PutMapping("/agent/{agentId}")
    Agent updateBluePill(@RequestBody Agent agentPutRequest, @PathVariable Long agentId) {
        return agentService.updateAgent(agentPutRequest, agentId);
    }

    @DeleteMapping("/agent/{agentId}")
    String deleteBluePill(@PathVariable Long agentId) {
        return agentService.deleteAgent(agentId);
    }
}
