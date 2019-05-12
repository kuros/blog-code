package in.kuros.custom;

import in.kuros.entity.UserEntity;
import in.kuros.entity.UserRoles;
import in.kuros.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        final List<UserRoles> userRoles = getUserIfAuthenticated(username, password);

        return new UsernamePasswordAuthenticationToken(username, null, getGrantedAuthorities(userRoles));
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthorities(final List<UserRoles> userRoles) {
        return userRoles
                .stream()
                .map(role -> (GrantedAuthority) role::getRole)
                .collect(Collectors.toList());
    }

    private List<UserRoles> getUserIfAuthenticated(final String username, final String password) {
        final UserEntity entity = userRepository.findByUserName(username);

        if (entity == null) {
            throw new UsernameNotFoundException("Authentication failed");
        }

        if (!entity.getPassword().equals(password)) {
            throw new UsernameNotFoundException("Authentication failed");
        }

        return entity.getUserRoles();
    }

    @Override
    public boolean supports(final Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
