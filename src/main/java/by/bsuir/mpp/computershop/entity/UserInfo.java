package by.bsuir.mpp.computershop.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo {

    @Id
    @Column(name = "auth_id")
    private Long authId;

    @MapsId
    @OneToOne
    @JoinColumn(name = "auth_id", unique = true, nullable = false)
    private UserAuth userAuth;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "phone")
    private String phone;

    public UserInfo() {

    }

    public UserInfo(UserInfo userInfo) {
        this.firstName = userInfo.firstName;
        this.lastName = userInfo.lastName;
        this.patronymic = userInfo.patronymic;
        this.phone = userInfo.phone;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
        this.authId = userAuth.getId();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return this.patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
