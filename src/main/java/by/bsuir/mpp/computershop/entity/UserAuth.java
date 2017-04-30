package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "user_auth")
public class UserAuth extends BaseEntity<Long> {

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "pass_hash", nullable = false,
            updatable = false)
    private String passHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false,
            columnDefinition = Role.TYPE_DEFINITION)
    private Role role;

    @Column(name = "blocked", nullable = false,
            updatable = false, insertable = false)
    private Boolean blocked;

    @Column(name = "removed", nullable = false,
            updatable = false, insertable = false)
    private Boolean removed;

    // TODO: Test cascadeType
    @OneToOne(mappedBy = "userAuth", fetch = FetchType.LAZY,
            optional = false, cascade = CascadeType.MERGE)
    private UserInfo userInfo;

    public UserAuth() {

    }

    public UserAuth(UserAuth userAuth, boolean copyAuth) {
        email = userAuth.email;
        role = userAuth.role;
        passHash = userAuth.passHash;
        blocked = userAuth.blocked;
        removed = userAuth.removed;
        if (copyAuth) {
            setUserInfo(new UserInfo(userAuth.userInfo));
        }
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
        userInfo.setUserAuth(this);
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

        public static final List<Role> VALUES = Collections.unmodifiableList(Arrays.asList(values()));

        public static final int SIZE = VALUES.size();

        public abstract String toString();
    }
}
