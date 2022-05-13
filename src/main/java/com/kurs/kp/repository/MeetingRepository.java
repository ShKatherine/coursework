package com.kurs.kp.repository;



import com.kurs.kp.model.Meeting;
import com.kurs.kp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting,Long> {


}