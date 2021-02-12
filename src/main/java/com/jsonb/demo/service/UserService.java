package com.jsonb.demo.service;

import com.jsonb.demo.entity.Users;
import com.jsonb.demo.model.Address;
import com.jsonb.demo.model.PersonalDetails;
import com.jsonb.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void createNewUserWithJsonb(String firstName) {
        Users user = new Users();
        user.setFirstName(firstName + Thread.currentThread().getId());
        user.setLastName(firstName);
        PersonalDetails personalDetails = new PersonalDetails();
        ArrayList<String> children = new ArrayList<>();
        children.add("lory");
        children.add("jack");
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
        userRepository.updateJsonbData(personalDetails, id);
    }

    @Transactional
    public void addToArray(int id) {
        userRepository.addToChildArray("tom", id);
    }

    @Transactional
    public void removeFromChildArray(int id) {
        userRepository.removeFromChildArray("tom", id);

    }

    public ArrayList<Users> readSalaryContains(double salary) {
        return  userRepository.getRecordsBySalary(salary);
    }

    public Users createNewUserWithAllDetails(PersonalDetails personalDetails) {
        Users user = new Users();
        user.setFirstName("first" + Thread.currentThread().getId());
        user.setLastName("last" + Thread.currentThread().getId());
        user.setPersonalDetails(personalDetails);
        return  userRepository.save(user);

    }
}