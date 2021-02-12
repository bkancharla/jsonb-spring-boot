package com.jsonb.demo.repository;

import com.jsonb.demo.entity.Users;
import com.jsonb.demo.model.PersonalDetails;

import java.util.ArrayList;


public interface CustomJsonbRepository {

    void updateJsonbData(
            PersonalDetails personalDetails, int primaryKey);

    void addToChildArray(String data, int primaryKey);
    void removeFromChildArray(String childName, int id);
    ArrayList<Users> getRecordsBySalary(double salary);

}
