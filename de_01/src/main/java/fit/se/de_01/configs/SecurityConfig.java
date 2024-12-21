package fit.se.de_01.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

/**
 * @description
 * @author: vie
 * @date: 18/12/24
 */
@Component
@EnableWebSecurity
public class SecurityConfig {
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(request -> request
                  .requestMatchers("/api/**").permitAll()
                  .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults());
      return http.build();
   }

   @Bean
   public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
      UserDetails user = User.withUsername("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER").build();

      UserDetails admin = User.withUsername("admin")
            .password(new BCryptPasswordEncoder().encode("password"))
            .roles("ADMIN", "USER").build();
      return new InMemoryUserDetailsManager(user, admin);
   }

   @Bean
   PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }
}
