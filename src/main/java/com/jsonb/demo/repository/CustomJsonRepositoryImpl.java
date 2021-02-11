package com.jsonb.demo.repository;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;

@Repository

public class CustomJsonRepositoryImpl implements CustomJsonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void jsonb(
            HashMap<String, String> jsonb) {
        entityManager.createNativeQuery(
                "UPDATE jsonbtest  SET properties =  properties || :jsonb")
                .unwrap(NativeQuery.class)
                .setParameter("jsonb", jsonb, JsonBinaryType.INSTANCE)
                .executeUpdate();
    }



}
