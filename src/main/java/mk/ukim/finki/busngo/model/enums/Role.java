package mk.ukim.finki.busngo.model.enums;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_PASSENGER,
    ROLE_DRIVER,
    ROLE_CONDUCTOR,
    ROLE_ADMIN;


    @Override
    public String getAuthority() {
        return name();
    }
}
