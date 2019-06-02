package com.apap.tugasakhir.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/images/**").permitAll()
			.antMatchers("/logout/**").hasAnyAuthority("admin", "staff")
			.antMatchers("/lab/kebutuhan/tambah/**").hasAnyAuthority("staff")
			.antMatchers("/lab/kebutuhan/**").hasAnyAuthority("admin", "staff")
			.antMatchers("/lab/kebutuhan/ubah/**").hasAnyAuthority("admin")
			.antMatchers("/lab/pemeriksaan/permintaan/**").hasAnyAuthority("admin", "staff")
			.antMatchers("/lab/pemeriksaan/**").hasAnyAuthority("admin", "staff")
			.antMatchers("/lab/jadwal-jaga/tambah/**").hasAnyAuthority("admin")
			.antMatchers("/lab/jadwal-jaga/**").hasAnyAuthority("admin", "staff")
			.antMatchers("/lab / jadwal-jaga/ubah/**").hasAnyAuthority("admin")
			.antMatchers("/lab/stok/tambah/**").hasAnyAuthority("admin")
			.antMatchers("/lab/stok**").hasAnyAuthority("admin", "staff")
			.antMatchers("/lab/stok/ubah/**").hasAnyAuthority("admin")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
			.permitAll();
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private UserDetailsService userDS;
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDS).passwordEncoder(encoder());
	}
}
