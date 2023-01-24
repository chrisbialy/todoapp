package pl.todo.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {



    /*The login/security has not been fully implemented.
      The Session part is missing so, a logged-in user/admin can access specific pages [userlist, usersearch, todolist, etc]
      and display a list of users, todolist items per user, modify/delete the data etc.
      Logged-in user should be able to access his data, modify it, save & delete etc. */


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors();
       // http.authorizeRequests()
                //.antMatchers("/user").authenticated()
                //.antMatchers("/todolist").permitAll()
                //.antMatchers("/todolist").hasAuthority("admin")
                //.antMatchers("/user").authenticated()
                //.anyRequest()
               // .permitAll()
                //.and()
                //.httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
