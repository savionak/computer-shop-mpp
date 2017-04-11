package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_auth")

public class EmployeeAuth extends BaseEntity<Long> {

    @Enumerated( EnumType.ORDINAL)
    @Column(name ="role ", nullable = false)
    private EmployeeRole role;

    @Column(name = "login",unique = true, nullable = false)
    private String login;

    @Column(name = "pass_hash",unique = true, nullable = false)
    private String passHash;

    @Column(name ="blocked", nullable = false, columnDefinition = "bool default false")
    private Boolean blocked;

    @Column(name ="deleted", nullable = false, columnDefinition = "bool default false")
    private Boolean deleted;

    @OneToOne(mappedBy = "auth", cascade = CascadeType.ALL)
    private EmployeeInfo employeeInfo;

    @OneToMany(mappedBy = "assembler", cascade = CascadeType.ALL)
    private List<AssemblerTask> assemblerTask;

    public EmployeeInfo getEmployeeInfo(){return employeeInfo;}
    public void setEmployeeInfo(EmployeeInfo employeeInfo){this.employeeInfo = employeeInfo;}

    public List<AssemblerTask> getAssemblerTask(){return assemblerTask;}
    public void setAssemblerTask(List<AssemblerTask> assemblerTask){this.assemblerTask = assemblerTask;}

    public String  getLogin(){
        return this.login;
    }
    public void setLogin (String  role_id) {this.login = login;    }

    public String getPassHash(){
        return this.passHash;
    }
    public void setPassHash(String passHash) {this.passHash = passHash;    }

    public Boolean getStatus(){
        return this.blocked;
    }
    public void setStatus(Boolean blocked) {
        this.blocked =blocked;
    }

    public Boolean getDeleted(){
        return this.deleted;
    }
    public void setDeleted(Boolean deleted) {
        this.deleted =deleted;
    }

    public EmployeeRole getRole(){
        return this.role;
    }
    public void setRole(EmployeeRole role) {
        this.role =role;
    }

}
