package com.okfinancial.diary;

//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	public WebSecurityConfig() {
//		// TODO Auto-generated constructor stub
//	}
//
//	public WebSecurityConfig(boolean disableDefaults) {
//		super(disableDefaults);
//		// TODO Auto-generated constructor stub
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin()
//				.loginPage("/login").failureUrl("/login?error").permitAll().and()
//				.logout().permitAll();
//	}
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("admin").password("admin")
//				.roles("ADMIN", "USER").and().withUser("user").password("user")
//				.roles("USER");
//	}

//}
