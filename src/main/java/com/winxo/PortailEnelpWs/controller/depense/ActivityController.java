package com.winxo.PortailEnelpWs.controller.depense;

import com.winxo.PortailEnelpWs.entities.depense.Activity;
import com.winxo.PortailEnelpWs.service.depense.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityController {

    private final ActivityService activityService;

    @GetMapping("/all")
    public ResponseEntity<List<Activity>> getAllActivities () {
        List<Activity> activitys = activityService.findAllActivities();
        return new ResponseEntity<>(activitys, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Activity> getActivityById (@PathVariable("id") Integer id) {
        Activity activity = activityService.findActivityById(id);
        return new ResponseEntity<>(activity, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Activity> updateActivity(@RequestBody Activity activity) {
        Activity updateActivity = activityService.updateActivity(activity);
        return new ResponseEntity<>(updateActivity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActivity(@PathVariable("id") Integer id) {
        activityService.deleteActivity(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
