package com.winxo.PortailEnelpWs.service;

import com.winxo.PortailEnelpWs.dao.request.SignUpRequest;
import com.winxo.PortailEnelpWs.dao.request.SigninRequest;
import com.winxo.PortailEnelpWs.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
