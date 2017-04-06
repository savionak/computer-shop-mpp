package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;

@Entity
@Table(name = "employee_auth")

public class EmployeeAuth extends BaseEntity<Long> {

    @Column(nullable = false)
    private int role_id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(unique = true, nullable = false)
    private String pass_hash;

    @Column( nullable = false)
    private String salt;

    @Enumerated(EnumType.ORDINAL)
    @Column( nullable = false)
    private Status status;

    public int getRole_id(){
        return this.role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String  getLogin(){
        return this.login;
    }

    public void setLogin (String  role_id) {this.login = login;    }

    public String  getPass_hash(){
        return this.pass_hash;
    }

    public void setPass_hash (String  pass_hash) {this.pass_hash = pass_hash;    }

    public String  getSalt(){
        return this.salt;
    }

    public void setSalt (String  salt) {this.salt = salt;    }

    public Status getStatus(){
        return this.status;
    }

    public void setStatus(Status status) {
        this.status =status;
    }

}
