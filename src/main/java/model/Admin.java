package model;
import javax.persistence.*;


@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idAdm")
    private Integer idAdm;

    @Column(nullable = false, unique = true, length = 45)
    private String emailAdm;

    @Column(nullable = false, length = 64)
    private String passwordAdm;

    //конструкторы
    public Admin(){}
    public  Admin(Integer idAdm,String emailAdm, String passwordAdm){
        this.idAdm=idAdm;
        this.emailAdm=emailAdm;
        this.passwordAdm=passwordAdm;
    }

    public Integer getId() {
        return idAdm;
    }
    public void setId(Integer idAdm) {
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
