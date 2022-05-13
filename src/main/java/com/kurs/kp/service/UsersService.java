package com.kurs.kp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.kurs.kp.model.User;
import com.kurs.kp.model.Programmer;
import com.kurs.kp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UsersService extends Serv {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProgrammerRepository programmerRepository;

    public void save(User users)
    {
        userRepository.save(users);
    }

    public User get(Long id)
    {
        return userRepository.findById(id).get();
    }
    public void delete(){
        System.out.println("Deleted");
    }

    public void delete(Long id)
    {
        programmerRepository.deleteById(id);
    }

}
