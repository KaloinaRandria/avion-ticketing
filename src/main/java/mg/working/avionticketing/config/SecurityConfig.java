package mg.working.avionticketing.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/assets/**", "/sign-up-page", "/sign-up").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login-page")      // ta page de login personnalisée
                        .loginProcessingUrl("/login")  // URL où le formulaire POST est envoyé
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());
        return http.build();
    }
}
