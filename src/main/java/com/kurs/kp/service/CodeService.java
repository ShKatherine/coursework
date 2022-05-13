package com.kurs.kp.service;
import com.kurs.kp.model.Code;
import com.kurs.kp.model.Programmer;
import com.kurs.kp.repository.CodeRepository;
import com.kurs.kp.repository.ProgrammerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CodeService extends Rev{
    @Autowired
    private CodeRepository codeRepository;

    public void save(Code code)
    {
        codeRepository.save(code);
    }

    public Code get(Long id)
    {
        return codeRepository.findById(id).get();
    }

    public void delete(Long id)
    {
        codeRepository.deleteById(id);
    }

}
