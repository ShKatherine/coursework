package com.kurs.kp.repository;

import com.kurs.kp.model.Code;
import org.springframework.data.repository.CrudRepository;
import com.kurs.kp.model.Admin;
import com.kurs.kp.model.Comment;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends CrudRepository<Comment,Long> {
    Comment findByCode(Code code);
}