package by.bsuir.mpp.computershop.entity;

import by.bsuir.mpp.computershop.dto.UserInfoDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static by.bsuir.mpp.computershop.config.ModelMapperConfiguration.modelMapper;
import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

@Entity
@Table(name = "user_info")
public class UserInfo extends BaseEntity<Long> {
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_id", unique = true, nullable = false)
    private UserAuth userAuth;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = NON_EMPTY_STRING_REGEX, message = CANNOT_BE_EMPTY_MESSAGE)
    @Column(name = "phone", nullable = false)
    private String phone;

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
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

    @Override
    public UserInfoDto toDto() {
        return modelMapper.map(this, UserInfoDto.class);
    }
}
