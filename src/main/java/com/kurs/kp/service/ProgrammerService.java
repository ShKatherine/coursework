package com.kurs.kp.service;

import com.kurs.kp.model.Programmer;
import com.kurs.kp.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class ProgrammerService extends Rev{
    @Autowired
    private ProgrammerRepository programmerRepository;

    public void save(Programmer programmer)
    {
        programmerRepository.save(programmer);
    }

    public Programmer get(Long id)
    {
        return programmerRepository.findById(id).get();
    }

    public void delete(Long id)
    {
        programmerRepository.deleteById(id);
    }
}
