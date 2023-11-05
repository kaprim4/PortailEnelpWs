package com.winxo.PortailEnelpWs.dao.response;

import com.winxo.PortailEnelpWs.entities.GasStation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
    /*private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private Integer gasStation_id;
    private String gasStation_code_sap;*/
    private String token;
    //private String avatar;
}
