package com.winxo.PortailEnelpWs.controller;

import com.winxo.PortailEnelpWs.entities.City;
import com.winxo.PortailEnelpWs.entities.Supervisor;
import com.winxo.PortailEnelpWs.repository.SupervisorRepository;
import com.winxo.PortailEnelpWs.service.SupervisorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        if (supervisorRepository.findSupervisorById(supervisor.getId()).isPresent()) {
            Supervisor supervisor1 = supervisorRepository.findSupervisorById(supervisor.getId()).get();
            supervisor1.setFirstName(supervisor.getFirstName());
            supervisor1.setLastName(supervisor.getLastName());
            supervisor1.setEmail(supervisor.getEmail());
            supervisor1.setUpdatedAt(LocalDateTime.now());
            supervisor1.setIsDeleted(false);
            supervisor1.setIsActivated(supervisor.getIsActivated());
            supervisorRepository.save(supervisor1);
            System.out.println(supervisor1);
            return new ResponseEntity<>(supervisor1, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
