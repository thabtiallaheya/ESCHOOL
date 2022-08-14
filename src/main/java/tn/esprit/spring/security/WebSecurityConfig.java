package tn.esprit.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tn.esprit.spring.service.MyUserDetailsService;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/registration").permitAll()
	.antMatchers("/parent/retrieve-all-parents}").access("hasRole('ASSISTANT')")
	.antMatchers("/parent/retrieve-all-parents}").access("hasRole('PARENT')")
	.antMatchers("/classe/retrieve-all-class}").access("hasRole('DIRECTEUR')")
	.antMatchers("/classe/retrieve-all-class}").access("hasRole('PROFESSEUR')")
	.anyRequest()
	.authenticated()
	.and()
	.httpBasic().and().csrf().disable();
	//.antMatchers("/getRevenuBrutProduit/{idProduit}/{startDate}/{endDate}").access("hasRole('SUPERADMIN')")

	//.antMatchers("/parent}").permitAll()
	//.antMatchers("/produit/retrieve-all-produits").access("hasRole('ADMIN')")
	//.antMatchers("/client/retrieve-all-clients").access("hasRole('ADMIN')")
	
	}
}
