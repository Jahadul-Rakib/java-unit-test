package com.rakib.testing.repository;

import com.rakib.testing.model.UserInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ActiveProfiles("test")
@DataMongoTest
@ExtendWith(SpringExtension.class)
class UserInformationRepositoryTest {

    @Autowired
    UserInformationRepository informationRepository;

    @Test
    @Order(1)
    @DisplayName("add to user in db")
    void addUserRepo() {
        UserInformation user1 = UserInformation.builder()
                .userName("rakib")
                .userHomeDistrict("DK")
                .userPhoneNumber("0000")
                .build();
        UserInformation save = informationRepository.save(user1);
        System.out.println(save);
        assert save.getUserHomeDistrict().equals("DK");
    }

    @Test
    @Order(2)
    @DisplayName("add to user in db")
    void getUserByDistrict() {
        List<UserInformation> getList = informationRepository.findAllByUserHomeDistrict("DK");
        System.out.println(getList.get(0).getUserHomeDistrict());
        assert getList.get(0).getUserHomeDistrict().equals("DK");
    }
}