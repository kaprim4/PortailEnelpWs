package com.winxo.PortailEnelpWs.repository;

import com.winxo.PortailEnelpWs.entities.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupervisorRepository extends JpaRepository<Supervisor, Integer> {
    Optional<Supervisor> findSupervisorById(Integer id);
}
