package com.winxo.PortailEnelpWs.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.winxo.PortailEnelpWs.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{
    @Query(value = "select u from User u inner join GasStation g on u.gasStation.id = g.id where u.username = :username")
    Optional<User> findByUserName(String username);

    Optional<User> findUserById(Integer id);

    void deleteUserById(Integer id);
}
