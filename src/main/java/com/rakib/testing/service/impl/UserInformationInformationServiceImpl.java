package com.rakib.testing.service.impl;

import com.rakib.testing.model.UserInformation;
import com.rakib.testing.repository.UserInformationRepository;
import com.rakib.testing.service.UserInformationService;
import com.rakib.testing.service.dto.UserRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInformationInformationServiceImpl implements UserInformationService {
    private final UserInformationRepository userInformationRepository;
    public UserInformationInformationServiceImpl(UserInformationRepository userInformationRepository) {
        this.userInformationRepository = userInformationRepository;
    }


    @Override
    public UserInformation addUser(UserRequestDTO requestDTO) {
        return userInformationRepository.save(UserInformation.builder()
                .userName(requestDTO.getUserName())
                .userPhoneNumber(requestDTO.getUserPhoneNumber())
                .userHomeDistrict(requestDTO.getUserHomeDistrict())
                .build());
    }

    @Override
    public List<UserInformation> getUserByDistrict(String district) {
        return userInformationRepository.findAllByUserHomeDistrict(district);
    }
}
