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
    private String token;
}
