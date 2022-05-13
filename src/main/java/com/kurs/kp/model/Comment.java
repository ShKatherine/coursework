package com.kurs.kp.model;
import javax.persistence.*;

@Entity
@Table(name = "comment")
public class  Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idComment")
    private Long idComment;

    @Column(name = "type", length = 45)
    private String typ;

    @Column(name = "comment", length = 300)
    private String com;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "codeId")
    private Code code;

    public Comment (){}

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }
}