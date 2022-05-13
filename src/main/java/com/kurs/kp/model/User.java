package com.kurs.kp.model;
import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idU")
    private Long idU;

    @Column(name = "emailUser",nullable = false, unique = true, length = 45)
    private String emailU;

    @Column(name = "passwordlUser",nullable = false, length = 64)
    private String passwordU;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "prId", referencedColumnName = "idP")
    private Programmer programmer;


    public User(){}

    public Long getIdU() {
        return idU;
    }

    public void setIdU(Long idU) {
        this.idU = idU;
    }

    public String getEmailU() {
        return emailU;
    }

    public void setEmailU(String emailU) {
        this.emailU = emailU;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }

    public Programmer getProgrammer() {
        return programmer;
    }

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }
}
