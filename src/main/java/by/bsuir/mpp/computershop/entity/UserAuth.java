package by.bsuir.mpp.computershop.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

@Entity
@Table(name = "user_auth")
@DynamicInsert
public class UserAuth extends BaseEntity<Long> {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = EMAIL_REGEX, message = INVALID_VALUE_MESSAGE)
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "pass_hash", nullable = false)
    private String passHash;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false,
            columnDefinition = Role.TYPE_DEFINITION)
    private Role role;

    @Column(name = "blocked", nullable = false)
    private Boolean blocked = false;

    @Column(name = "removed", nullable = false)
    private Boolean removed = false;

    @OneToOne(mappedBy = "userAuth", fetch = FetchType.LAZY)
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

    public Boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
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

        public static final String TYPE_DEFINITION = "ENUM ('MANAGER', 'DIRECTOR', 'ADMIN')";

        public abstract String toString();
    }
}
