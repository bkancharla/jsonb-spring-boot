package com.jsonb.demo.repository;

import com.jsonb.demo.model.PersonalDetails;


public interface CustomJsonbRepository {

    void updateJsonbData(
            PersonalDetails personalDetails, int primaryKey);
}
