package com.kurs.kp.repository;

import org.springframework.data.repository.CrudRepository;
import com.kurs.kp.model.Programmer;
import com.kurs.kp.model.Requires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RequiresRepository extends CrudRepository<Requires,Long> {
    Requires findByReq(String req);
}