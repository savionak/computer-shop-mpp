package by.bsuir.mpp.computershop.dto;

import by.bsuir.mpp.computershop.entity.UserAuth.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

public class UserAuthDto extends BaseDto {
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    @Pattern(regexp = EMAIL_REGEX, message = INVALID_VALUE_MESSAGE)
    private String email;

    private String passHash;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private Role role;

    private Boolean blocked = false;

    private Boolean removed = false;

    private UserInfoDto userInfo;

    public UserAuthDto() {

    }

    public UserAuthDto(UserAuthDto userAuth) {
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

    public UserInfoDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoDto userInfo) {
        this.userInfo = userInfo;
    }
}
