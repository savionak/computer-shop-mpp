package by.bsuir.mpp.computershop.dto.full;

import by.bsuir.mpp.computershop.entity.UserAuth.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import static by.bsuir.mpp.computershop.utils.ValidationConstants.*;

public class UserAuthFullDto extends BaseFullDto<Long> {

    @SafeHtml
    @NotEmpty(message = CANNOT_BE_EMPTY_MESSAGE)
    @Pattern(regexp = EMAIL_REGEX, message = INVALID_VALUE_MESSAGE)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pass;

    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private Role role;

    // Separate endpoints to block/unblock user
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean blocked;

    // Separate endpoints to remove/restore user
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean removed = false;

    @Valid
    @NotNull(message = CANNOT_BE_NULL_MESSAGE)
    private UserInfoFullDto userInfo;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public UserInfoFullDto getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoFullDto userInfo) {
        this.userInfo = userInfo;
    }
}
