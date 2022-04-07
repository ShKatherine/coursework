package model;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "code")
public class  Code {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCode")
    private Integer idCode;

    @Column(nullable = false, unique = true, length = 45)
    private String language;


    @Temporal(TemporalType.DATE)
    @Column(nullable = false, unique = true)
    private Date date;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "prog_id")
    private Programmer programmer;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "reqId", referencedColumnName = "idReq")
    private Requires requires;

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
}
    //колонка для хранения кода
