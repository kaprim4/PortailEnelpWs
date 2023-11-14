package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.entities.Supervisor;

import java.util.List;

public interface SupervisorService {

    List<Supervisor> findAllSupervisors();

    Supervisor findSupervisorById(Integer id);

    Supervisor addSupervisor(Supervisor role);

    Supervisor updateSupervisor(Supervisor role);

    void deleteSupervisor(Integer id);
}
