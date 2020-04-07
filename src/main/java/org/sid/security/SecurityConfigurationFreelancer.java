package org.sid.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//@Configuration
//@EnableWebSecurity
public class SecurityConfigurationFreelancer extends WebSecurityConfigurerAdapter {
//	 public SecurityConfigurationFreelancer() {
//		super();
//	}
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("k@g.c").password(encoder().encode("123456789"))
//				.roles("FREELANCER");
//	}
//	@Bean
//	public static PasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.formLogin().loginPage("/loginFreelancer").permitAll()
//			.failureUrl("/loginErrorFreelancer?error=loginError")
//			.successForwardUrl("/connexionSuccessFreelancer")
//			;
//		http.authorizeRequests().antMatchers("/myFreelancerProfilePage","/freelancerPage").hasRole("FREELANCER");
//		http.logout().logoutUrl("/logout_Freelancer").logoutSuccessUrl("/").deleteCookies("JSESSIONID");
//		http.exceptionHandling().accessDeniedPage("/403");
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**");
//	}
}
