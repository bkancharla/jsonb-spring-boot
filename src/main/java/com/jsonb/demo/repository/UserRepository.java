package com.jsonb.demo.repository;

import com.jsonb.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, CustomJsonbRepository {

}
