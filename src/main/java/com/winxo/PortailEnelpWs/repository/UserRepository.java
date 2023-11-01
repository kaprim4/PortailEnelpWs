package com.winxo.PortailEnelpWs.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.winxo.PortailEnelpWs.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>
{

    @Query(value = "SELECT u FROM User u WHERE u.username LIKE :username")
    Optional<User> findByUserName(String username);

    Optional<User> findUserById(Integer id);

    void deleteUserById(Integer id);
}
