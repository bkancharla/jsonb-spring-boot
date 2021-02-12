package com.jsonb.demo.repository;

import com.jsonb.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>, CustomJsonbRepository {

}
