package by.vino.mygarage.util;

import by.vino.mygarage.dao.jpa.RoleEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityHelper {

    /**
     * Returns current user from security.
     *
     * @return user details
     * */
    public UserDetails getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (null == auth) {
            return null;
        }

        Object obj = auth.getPrincipal();

        if (obj instanceof UserDetails) {
            return (UserDetails) obj;
        } else {
            return null;
        }
    }

    public boolean isRoleAuthority(UserDetails userDetails, RoleEnum role) {
        return userDetails != null &&
                userDetails.getAuthorities().contains(new SimpleGrantedAuthority(role.name()));
    }
}
