package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.Supervisor;
import com.winxo.PortailEnelpWs.repository.SupervisorRepository;
import com.winxo.PortailEnelpWs.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/supervisors")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class SupervisorController {

    private final SupervisorService supervisorService;

    @Autowired
    private SupervisorRepository supervisorRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Supervisor>> getAllSupervisors () {
        List<Supervisor> supervisors = supervisorService.findAllSupervisors();
        return new ResponseEntity<>(supervisors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Supervisor> addSupervisor(@RequestBody Supervisor supervisor) {
        supervisor.setIsDeleted(false);
        Supervisor user_added = supervisorService.addSupervisor(supervisor);
        System.out.println(user_added);
        return new ResponseEntity<>(user_added, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Supervisor> getSupervisorById (@PathVariable("id") Integer id) {
        Optional<Supervisor> userOptional = supervisorRepository.findById(id);
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        Supervisor user_found = supervisorService.findSupervisorById(id);
        return new ResponseEntity<>(user_found, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Supervisor> updateSupervisor(@RequestBody Supervisor supervisor) {
        Optional<Supervisor> userOptional = supervisorRepository.findSupervisorById(supervisor.getId());
        if (userOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        supervisor.setIsDeleted(false);
        supervisorRepository.save(supervisor);
        System.out.println(supervisor);
        return new ResponseEntity<>(supervisor, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSupervisor(@PathVariable("id") Integer id) {
        Optional<Supervisor> supervisorOptional = supervisorRepository.findSupervisorById(id);
        if (supervisorOptional.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        supervisorService.deleteSupervisor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
