package pl.todo.security;

import pl.todo.entity.Users;
import pl.todo.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    Logger logger = LoggerFactory.getLogger(UserAuthenticationProvider.class);

    private UserRepository userRepository;

    private PasswordEncoder encoder;

    public UserAuthenticationProvider(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    /**
     * Get the username and password from authentication object and validate with password encoders matching method
     * @param authentication
     * @return
     * @throws AuthenticationException
     */

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        Users users = userRepository.findUserByUsername(username);
        if (users == null) {
            throw new BadCredentialsException("Details not found");
        }

        if (encoder.matches(password, users.getPassword())) {
            logger.info("Successfully Authenticated the user");
            return new UsernamePasswordAuthenticationToken(username, password, getUserRoles(users.getRoles().getRole()));
        } else {
            throw new BadCredentialsException("Password mismatch");
        }
    }

    /**  Get a list of roles - comma separated*/

    private List<GrantedAuthority> getUserRoles(String userRoles) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        String[] roles = userRoles.split(",");
        for (String role : roles) {
            logger.info("Role: " + role);
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.replaceAll("\\s+", "")));
        }

        return grantedAuthorityList;
    }

        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.equals(UsernamePasswordAuthenticationToken.class);
        }

    }

