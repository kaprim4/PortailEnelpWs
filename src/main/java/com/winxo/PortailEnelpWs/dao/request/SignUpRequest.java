package com.winxo.PortailEnelpWs.dao.request;

import com.winxo.PortailEnelpWs.entities.GasStation;
import com.winxo.PortailEnelpWs.entities.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest
{
    private Role role;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private GasStation gasStation;
    private Boolean isActivated;
    private Boolean isDeleted;
}
