package com.winxo.PortailEnelpWs.repository.depense;

import com.winxo.PortailEnelpWs.entities.depense.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
    Optional<Activity> findActivityById(Integer id);
    void deleteActivityById(Integer id);
}
