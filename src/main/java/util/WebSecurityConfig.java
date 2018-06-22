package util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "services", "repositories" })
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// /**
	// * Configuramos el acceso a URLs dependiendo del rol
	// */
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.csrf().disable().authorizeRequests()
	// .antMatchers("/css/**", "/img/**", "/script/**", "/", "/signup",
	// "/login/**").permitAll().anyRequest()
	// .authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/user/listUsers")
	// .and().logout().permitAll();
	// ;
	// }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//es asi porque no esta encriptada, si lo tuviera descomentar
		auth.userDetailsService(userDetailsService);//.passwordEncoder(bCryptPasswordEncoder());  
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		 .antMatchers("/css/**", "/img/**", "/script/**", "/", "/signup",
		 "/login/**").permitAll().anyRequest()
		 .authenticated().and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home")
		 .and().logout().permitAll();
	}

}
