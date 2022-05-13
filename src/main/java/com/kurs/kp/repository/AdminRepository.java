package com.kurs.kp.repository;

import org.springframework.data.repository.CrudRepository;
import  com.kurs.kp.model.Admin;
import com.kurs.kp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Long> {
    Admin findByEmailAdm(String emailAdm);
}

