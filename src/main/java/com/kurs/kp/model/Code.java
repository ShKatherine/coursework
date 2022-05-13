package com.kurs.kp.model;
import javax.persistence.*;
import java.util.Date;
import java.util.Collection;
@Entity
@Table(name = "code")
public class  Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCode")
    private Integer idCode;

    @Column(name = "language",nullable = false, length = 45)
    private String language;

    @Column(name = "document",nullable = false, length = 45)
    private String document;

    @Temporal(TemporalType.DATE)
    @Column(name = "date",nullable = false)
    private Date date;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "prog_id")
    private Programmer programmer;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "reqId", referencedColumnName = "idReq")
    private Requires requires;

    @OneToMany( mappedBy = "code", fetch = FetchType.EAGER)
    private Collection<Comment> commentCollection;

    public Code (){}

    public Integer getIdCode() {
        return idCode;
    }

    public void setIdCode(Integer idCode) {
        this.idCode = idCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Requires getRequires() {
        return requires;
    }

    public void setRequires(Requires requires) {
        this.requires = requires;
    }



    public Programmer getProgrammer() {
        return programmer;
    }

    public void setProgrammer(Programmer programmer) {
        this.programmer = programmer;
    }

    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
    //колонка для хранения кода
