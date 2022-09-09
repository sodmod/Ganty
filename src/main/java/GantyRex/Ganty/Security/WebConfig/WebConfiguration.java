package GantyRex.Ganty.Security.WebConfig;

import GantyRex.Ganty.Security.PasswordConfig.PasswordEncoder;
import GantyRex.Ganty.Users.StaffServices;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static GantyRex.Ganty.Enums.StaffRoles.*;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebConfiguration extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final StaffServices staffServices;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/administrator/staffs/admin").permitAll()
                .antMatchers("/customer/add").permitAll();//.anyRequest();
        http
                .csrf().disable()
                .authorizeRequests()

                .antMatchers("administrator/staffs/hod").hasRole(MANAGER.name())
                .antMatchers("administrator/staffs/staffs").hasAnyRole(HOD.name())
//                .antMatchers("customer").hasAnyRole(STAFF.name(), HOD.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder.bCryptPasswordEncoder());
        provider.setUserDetailsService(staffServices);
        return provider;
    }
}
