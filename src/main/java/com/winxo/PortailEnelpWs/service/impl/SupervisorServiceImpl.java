package com.winxo.PortailEnelpWs.service.impl;

import com.winxo.PortailEnelpWs.entities.Supervisor;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.SupervisorRepository;
import com.winxo.PortailEnelpWs.service.SupervisorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SupervisorServiceImpl implements SupervisorService
{

    private final SupervisorRepository supervisorRepository;

    @Autowired
    public SupervisorServiceImpl(SupervisorRepository supervisorRepository) {
        this.supervisorRepository = supervisorRepository;
    }

    public Supervisor addSupervisor(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    public List<Supervisor> findAllSupervisors() {
        return supervisorRepository.findAll();
    }

    public Supervisor updateSupervisor(Supervisor supervisor) {
        return supervisorRepository.save(supervisor);
    }

    public Supervisor findSupervisorById(Integer id) {
        return supervisorRepository
                .findSupervisorById(id)
                .orElseThrow(() -> new NotFoundException("Supervisor by id " + id + " was not found"));
    }

    public void deleteSupervisor(Integer id) {
        supervisorRepository.deleteById(id);
    }
}
