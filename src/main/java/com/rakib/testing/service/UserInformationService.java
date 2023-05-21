package com.rakib.testing.service;

import com.rakib.testing.model.UserInformation;
import com.rakib.testing.service.dto.UserRequestDTO;

import java.util.List;

public interface UserInformationService {
    UserInformation addUser(UserRequestDTO requestDTO);

    List<UserInformation> getUserByDistrict(String district);
}
