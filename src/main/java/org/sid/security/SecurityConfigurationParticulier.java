package org.sid.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//@Configuration
//@EnableWebSecurity
public class SecurityConfigurationParticulier extends WebSecurityConfigurerAdapter {
//	 public SecurityConfigurationParticulier() {
//		super();
//	}
//	 @Override
//		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//			BCryptPasswordEncoder a = new BCryptPasswordEncoder();
//
//			auth.inMemoryAuthentication().withUser("29kh@m.co").password(a.encode("pass29"))
//			.roles("PARTICULIER");
//		}
//		
//		@Override
//		public void configure(WebSecurity web) throws Exception {
//			web.ignoring().antMatchers("/resources/**");
//		}
//		protected void configure(HttpSecurity http) throws Exception {
//			http.csrf().disable();
//			http.formLogin().loginPage("/loginParticulier").permitAll()
//				.failureUrl("/loginErrorParticulier?error=loginError")
//				.successForwardUrl("/connexionSuccessParticulier")
//				;
//			http.authorizeRequests().antMatchers("/myParticulierProfilePage").hasRole("PARTICULIER");
//			http.logout().logoutUrl("/logout_Particulier").logoutSuccessUrl("/").deleteCookies("JSESSIONID");
//			http.exceptionHandling().accessDeniedPage("/403");
//	}
}
