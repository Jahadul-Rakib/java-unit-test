package com.rakib.testing.service.impl;

import com.rakib.testing.model.UserInformation;
import com.rakib.testing.repository.UserInformationRepository;
import com.rakib.testing.service.dto.UserRequestDTO;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserInformationImplTest {

    @Mock
    UserInformationRepository informationRepository;
    @InjectMocks
    UserInformationInformationServiceImpl userInformationServiceImpl;

    @Test
    @Order(1)
    @DisplayName("add to user in db")
    void addUser() {
        Mockito.when(informationRepository.save(Mockito.any())).thenReturn(UserInformation.builder()
                .ID(new ObjectId())
                .userName("Test-One")
                .userPhoneNumber("016800023583")
                .userHomeDistrict("DHAKA")
                .build());
        UserRequestDTO requestDTO = UserRequestDTO.builder()
                .userName("Test-One")
                .userPhoneNumber("016800023583")
                .userHomeDistrict("DHAKA")
                .build();
        UserInformation user1 = userInformationServiceImpl.addUser(requestDTO);


        System.out.println(user1.toString());
        assert user1.getUserHomeDistrict().equals("DHAKA");

    }
}
