package com.jsonb.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jsonb.demo.model.PersonalDetails;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity()
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

@TypeDef(
        name = "jsonb",
        typeClass = JsonBinaryType.class,
        defaultForType = PersonalDetails.class

)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
    @SequenceGenerator(name = "user_seq_gen", sequenceName = "user_seq_gen")
    private int id;
    @Column
    private String lastName;
    private String firstName;
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private PersonalDetails personalDetails;
}
