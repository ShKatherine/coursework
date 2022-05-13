package com.kurs.kp.repository;

import com.kurs.kp.model.Admin;
import com.kurs.kp.model.Programmer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProgrammerRepository extends CrudRepository<Programmer,Long> {
    Programmer findByIdP(Long idP);
}
