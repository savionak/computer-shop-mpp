package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee_auth")

public class EmployeeAuth extends BaseEntity<Long> {

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false,
            columnDefinition = "ENUM ('RECEIVER', 'ASSEMBLER', 'MANAGER', 'DIRECTOR', 'ADMIN')")
    private Role role;

    @Column(name = "pass_hash", unique = true, nullable = false)
    private String passHash;

    @Column(name = "blocked", columnDefinition = "bit", nullable = false)
    private Boolean blocked;

    @Column(name = "deleted", columnDefinition = "bit", nullable = false)
    private Boolean deleted;

    @OneToOne(mappedBy = "auth", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private EmployeeInfo employeeInfo;

    @OneToMany(mappedBy = "assembler")
    private List<AssemblerTask> assemblerTask;

    public EmployeeAuth() {

    }

    public EmployeeAuth(EmployeeAuth employeeAuth) {
        email = employeeAuth.email;
        role = employeeAuth.role;
        passHash = employeeAuth.passHash;
        blocked = employeeAuth.blocked;
        deleted = employeeAuth.deleted;
        employeeInfo = employeeAuth.employeeInfo;
    }

    public List<AssemblerTask> getAssemblerTask() {
        return assemblerTask;
    }

    public void setAssemblerTask(List<AssemblerTask> assemblerTask) {
        this.assemblerTask = assemblerTask;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getPassHash() {
        return this.passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public Boolean getStatus() {
        return this.blocked;
    }

    public void setStatus(Boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public enum Role {
        RECEIVER {
            public String toString() {
                return "Приемщик";
            }
        },
        ASSEMBLER {
            public String toString() {
                return "Сборщик ПК";
            }
        },
        MANAGER {
            public String toString() {
                return "Менеджер";
            }
        },
        DIRECTOR {
            public String toString() {
                return "Директор";
            }
        },
        ADMIN {
            public String toString() {
                return "Администратор";
            }
        };

        public abstract String toString();
    }
}
