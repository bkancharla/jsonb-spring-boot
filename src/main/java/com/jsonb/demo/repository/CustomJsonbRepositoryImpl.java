package com.jsonb.demo.repository;

import com.jsonb.demo.model.PersonalDetails;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository

public class CustomJsonbRepositoryImpl implements CustomJsonbRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void updateJsonbData(PersonalDetails personalDetails, int primaryKey) {
        entityManager.createNativeQuery(
                "UPDATE users  SET personal_details = personal_details || :personalDetails where id = :id")
                .unwrap(NativeQuery.class)
                .setParameter("personalDetails", personalDetails, JsonBinaryType.INSTANCE)
                .setParameter("id", primaryKey)

                .executeUpdate();
    }

    @Override
    public void addToChildArray(String childName, int primaryKey) {
        char quotes = '"';
        String childNameWithQuotes = quotes + childName + quotes;
        entityManager.createNativeQuery(
                "    UPDATE users\n" +
                        "SET personal_details = jsonb_set(personal_details, '{children, 999999}', :data  ,TRUE)\n" +
                        "WHERE id =  :id")
                .unwrap(NativeQuery.class)
                .setParameter("data", childNameWithQuotes, JsonBinaryType.INSTANCE)
                .setParameter("id", primaryKey)

                .executeUpdate();
    }

    @Override
    public void removeFromChildArray(String childName, int primaryKey) {

        entityManager.createNativeQuery("UPDATE users\n" +
                "SET personal_details = jsonb_set(personal_details, '{children}' ,(personal_details->'children') - :data)\n" +
                "WHERE id =  :id")
                .unwrap(NativeQuery.class)
                .setParameter("data", childName)
                .setParameter("id", primaryKey)

                .executeUpdate();
    }


}

