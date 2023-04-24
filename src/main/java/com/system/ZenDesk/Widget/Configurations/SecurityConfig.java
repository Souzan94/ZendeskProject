package com.system.ZenDesk.Widget.Configurations;
import com.system.ZenDesk.Widget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;


@Configuration
@EnableWebSecurity


public class SecurityConfig   extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;



    @Autowired
    private UserService userService;




    @Override
    protected void configure(HttpSecurity http) throws Exception {

http.csrf().disable().authorizeRequests()

                .antMatchers("/","/infos","/Checkinfos")
                .permitAll()
                .antMatchers("/generateCode","/codepage").hasAuthority("PRE_AUTH")
                .antMatchers("/admin","/dashboard").hasAuthority("ROLE_ADMIN")
                .antMatchers("/user","/dashboard").hasAuthority("ROLE_USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/infos")
                .defaultSuccessUrl("/generateCode")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .deleteCookies("remove")
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
    }


    @Autowired
    public  void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

         BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    public void  configure(WebSecurity web){
      web.ignoring().antMatchers("/resources/**","/css/**","/js/**","/images/**");

    }



}
