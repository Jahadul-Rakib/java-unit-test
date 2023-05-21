package com.rakib.testing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value = "user")
public class UserInformation implements Serializable {
    @Serial
    private static final long serialVersionUID = 8571261118900116242L;

    @Id
    private ObjectId ID;
    private String userName;
    private String userHomeDistrict;
    private String userPhoneNumber;
}
