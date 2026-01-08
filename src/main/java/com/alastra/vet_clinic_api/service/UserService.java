package com.alastra.vet_clinic_api.service;

import com.alastra.vet_clinic_api.dto.CreateUserRequest;
import com.alastra.vet_clinic_api.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(CreateUserRequest request);
}

