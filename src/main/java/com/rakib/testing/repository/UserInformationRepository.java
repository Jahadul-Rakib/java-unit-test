package com.rakib.testing.repository;

import com.rakib.testing.model.UserInformation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInformationRepository extends MongoRepository<UserInformation, ObjectId> {
    List<UserInformation> findAllByUserHomeDistrict(String userHomeDistrict);
}
