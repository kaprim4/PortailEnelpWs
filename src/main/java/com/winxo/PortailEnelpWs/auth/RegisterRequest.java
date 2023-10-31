package com.winxo.PortailEnelpWs.auth;

import com.winxo.PortailEnelpWs.user.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private Integer id;
    private Integer station_id;
    private Integer profile_id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Boolean isActivated;
    private Boolean isDeleted;
    private Role role;
}
