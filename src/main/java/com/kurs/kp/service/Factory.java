package com.kurs.kp.service;

public class Factory {
    public  Rev createRev(Role type){
        Rev ns = null;
        switch (type) {
            case PROGRAMMER:
                ns = new ProgrammerService();
                break;
            case CODE:
                ns = new CodeService();
                break;
        }
        return ns;
    }

}
