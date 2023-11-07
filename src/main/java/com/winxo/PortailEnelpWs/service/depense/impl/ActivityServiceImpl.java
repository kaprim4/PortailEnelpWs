package com.winxo.PortailEnelpWs.service.depense.impl;

import com.winxo.PortailEnelpWs.entities.depense.Activity;
import com.winxo.PortailEnelpWs.exception.NotFoundException;
import com.winxo.PortailEnelpWs.repository.depense.ActivityRepository;
import com.winxo.PortailEnelpWs.service.depense.ActivityService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService
{
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Activity addActivity(Activity employee) {
        return activityRepository.save(employee);
    }

    public List<Activity> findAllActivities() {
        return activityRepository.findAll();
    }

    public Activity updateActivity(Activity employee) {
        return activityRepository.save(employee);
    }

    public Activity findActivityById(Integer id) {
        return activityRepository.findActivityById(id)
                .orElseThrow(() -> new NotFoundException("Activity by id " + id + " was not found"));
    }

    public void deleteActivity(Integer id){
        activityRepository.deleteActivityById(id);
    }
}
