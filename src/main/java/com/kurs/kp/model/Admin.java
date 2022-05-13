package com.kurs.kp.model;
import javax.persistence.*;


@Entity
@Table(name = "admins")
public class Admin {

    private static Admin instance;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAdm")
    private Long idAdm;

    @Column(name = "emailAdm",nullable = false, unique = true, length = 45)
    private String emailAdm;

    @Column(name = "passwordAdm",nullable = false, length = 64)
    private String passwordAdm;

    //конструкторы
    private Admin(){}
    private  Admin(Long idAdm,String emailAdm, String passwordAdm){
        this.idAdm=idAdm;
        this.emailAdm=emailAdm;
        this.passwordAdm=passwordAdm;
    }

    public static Admin getInstance(){
        if(instance==null){
            instance = new Admin();
        }
        return instance;
    }
    public static Admin getInstance(Long idAdm, String emailAdm, String passwordAdm){
        if(instance==null){
            instance = new Admin(idAdm, emailAdm, passwordAdm);
        }
        return instance;
    }



    public Long getId() {
        return idAdm;
    }
    public void setId(Long idAdm) {
        this.idAdm = idAdm;
    }

    public String getEmail() {
        return emailAdm;
    }
    public void setEmail(String emailAdm) {
        this.emailAdm = emailAdm;
    }

    public String getPassword() {
        return passwordAdm;
    }
    public void setPassword(String passwordAdm) {
        this.passwordAdm = passwordAdm;
    }


}
