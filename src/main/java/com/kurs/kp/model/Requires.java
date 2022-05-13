package com.kurs.kp.model;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "requires")
public class  Requires {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idReq")
    private Long idReq;

    @Column(name = "requires",nullable = false)
    private String req;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "requires")
    private Code code;

    public Requires() {
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Long getIdReq() {
        return idReq;
    }

    public void setIdReq(Long idReq) {
        this.idReq = idReq;
    }

    public String getReq() {
        return req;
    }

    public void setReq(String req) {
        this.req = req;
    }
}