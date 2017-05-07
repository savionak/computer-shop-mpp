package by.bsuir.mpp.computershop.config.security.userdetails;

import by.bsuir.mpp.computershop.entity.UserAuth;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.beans.Transient;
import java.io.Serializable;
import java.util.Collection;

public class UserAuthDetails extends UserAuth implements UserDetails, Serializable {

    UserAuthDetails(UserAuth user) {
        super(user, true);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(
                getRole().name()
        );
    }

    @Transient
    @Override
    public String getPassword() {
        return getPassHash();
    }

    @Transient
    @Override
    public String getUsername() {
        return getEmail();
    }

    @Transient
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isAccountNonLocked() {
        return !isBlocked();
    }

    @Transient
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Transient
    @Override
    public boolean isEnabled() {
        return !isRemoved();
    }
}
