package com.kurs.kp.repository;

import com.kurs.kp.model.Programmer;
import org.springframework.data.repository.CrudRepository;
import com.kurs.kp.model.Admin;
import com.kurs.kp.model.Code;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CodeRepository extends CrudRepository<Code,Long> {
    Code findByDocument(String document);
    Code findByIdCode(Integer idCode);
    Code findByProgrammer(Programmer programmer);
}