package model;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "programmer")
public class  Programmer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idP")
    private Integer idP;

    @Column(nullable = false, unique = true, length = 45)
    private String nameP;
    @Column(nullable = false, unique = true, length = 45)
    private String surnameP;
    @Column(nullable = false, length = 64)
    private String position;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "programmer")
    private User users;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programmer", fetch = FetchType.EAGER)
    private Collection<Code> codeCollection;

    public Programmer(){}

    public Integer getIdP() {
        return idP;
    }

    public void setIdP(Integer idP) {
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
}


