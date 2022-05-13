package com.kurs.kp.model;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "programmer")
public class  Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idP")
    private Long idP;

    @Column(name = "nameProgrammer",nullable = false, length = 45)
    private String nameP;
    @Column(name = "surnameProgrammer",nullable = false, length = 45)
    private String surnameP;
    @Column(name="position",nullable = false, length = 64)
    private String position;



    @OneToOne(cascade = CascadeType.ALL, mappedBy = "programmer")
    private User users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programmer", fetch = FetchType.EAGER)
    private Collection<Code> codeCollection;

    public Programmer(){}

    public Long getIdP() {
        return idP;
    }

    public void setIdP(Long idP) {
        this.idP = idP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getSurnameP() {
        return surnameP;
    }

    public void setSurnameP(String surnameP) {
        this.surnameP = surnameP;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public Collection<Code> getCodeCollection() {
        return codeCollection;
    }

    public void setCodeCollection(Collection<Code> codeCollection) {
        this.codeCollection = codeCollection;
    }
}


