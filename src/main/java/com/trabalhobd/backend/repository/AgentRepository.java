package com.trabalhobd.backend.repository;

import com.trabalhobd.backend.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
