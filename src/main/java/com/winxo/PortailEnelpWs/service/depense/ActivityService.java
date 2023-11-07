package com.winxo.PortailEnelpWs.service.depense;

import com.winxo.PortailEnelpWs.entities.depense.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> findAllActivities();

    Activity findActivityById(Integer id);

    Activity updateActivity(Activity user);

    void deleteActivity(Integer id);
}
