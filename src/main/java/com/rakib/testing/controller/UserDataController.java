package com.rakib.testing.controller;

import com.rakib.testing.service.UserInformationService;
import com.rakib.testing.service.dto.UserRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserDataController {
    private final UserInformationService userInformationService;

    public UserDataController(UserInformationService userInformationService) {
        this.userInformationService = userInformationService;
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userInformationService.addUser(userRequestDTO));
    }

    @GetMapping("{district}")
    public ResponseEntity<?> getUser(@PathVariable("district") String district) {
        System.out.println("come to the controller");
        return ResponseEntity.ok(userInformationService.getUserByDistrict(district));
    }
}
