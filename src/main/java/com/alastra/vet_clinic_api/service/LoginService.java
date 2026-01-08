package com.alastra.vet_clinic_api.service;

import com.alastra.vet_clinic_api.dto.LoginRequest;
import com.alastra.vet_clinic_api.dto.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest request);
}
