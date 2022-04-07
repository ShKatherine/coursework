package model;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "requires")
public class  Requires {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idReq")
    private Integer idReq;

    // поле ссылка на требования

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

    public Integer getIdReq() {
        return idReq;
    }

    public void setIdReq(Integer idReq) {
        this.idReq = idReq;
    }
}