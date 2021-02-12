package com.jsonb.demo.service;

import com.jsonb.demo.entity.User;
import com.jsonb.demo.model.Address;
import com.jsonb.demo.model.PersonalDetails;
import com.jsonb.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createNewUserWithJsonb(String firstName) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(firstName);
        PersonalDetails personalDetails = new PersonalDetails();
        String[] children = {"lory", "jack"};
        personalDetails.setChildren(children);
        personalDetails.setPhoneNumber("333-333-0000");
        personalDetails.setSalary(1_00_000.00);
        Address address = new Address();
        address.setCity("columbus");
        address.setState("ohio");
        address.setCountry("usa");
        personalDetails.setAddress(address);
        user.setPersonalDetails(personalDetails);
        userRepository.save(user);
    }

    @Transactional
    public void updateUserSalary(int id) {
        PersonalDetails personalDetails = new PersonalDetails();
        personalDetails.setSalary(1_50_000.00);
        userRepository.updateJsonbData(personalDetails,id);
    }
}