package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user_auth")
public class UserAuth extends BaseEntity<Long> {

    @NotNull(message = "Email cannot be null")
    @Pattern(regexp = "^(?!\\s*$).+", message = "Invalid email")
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "pass_hash", nullable = false)
    private String passHash;

    @NotNull(message = "Role cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false,
            columnDefinition = "ENUM ('MANAGER', 'DIRECTOR', 'ADMIN')")
    private Role role;

    @NotNull(message = "Blocked property cannot be null")
    @Column(name = "blocked", nullable = false)
    private boolean blocked = false;

    @NotNull(message = "Removed property cannot be null")
    @Column(name = "removed", nullable = false)
    private boolean removed = false;

    @OneToOne(cascade = CascadeType.ALL)
    private UserInfo userInfo;

    public UserAuth() {

    }

    public UserAuth(UserAuth userAuth) {
        email = userAuth.email;
        role = userAuth.role;
        passHash = userAuth.passHash;
        blocked = userAuth.blocked;
        removed = userAuth.removed;
        userInfo = userAuth.userInfo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassHash() {
        return this.passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Boolean isRemoved() {
        return this.removed;
    }

    public void setRemoved(Boolean removed) {
        this.removed = removed;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public enum Role {
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
