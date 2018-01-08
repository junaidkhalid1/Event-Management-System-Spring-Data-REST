package fr.junaid.eventmanagement;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // To tell Spring that it's Java based configuration for Spring.
@EnableGlobalMethodSecurity(prePostEnabled=true) // To enable method level security before and after invoking a method
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("junaid").password("junaid").roles("USER")
		.and().withUser("admin").password("admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/* Authentication: httpBasic tells Spring to enable basic authentication (Client needs to pass user name and password)
		 * Authorization: To authorize request we can pass HTTP methods or URLs or both using antMatchers method (authorize to
		 * perform POST, PUT and PATCH for an event). So whatever is in antMatchers method matches in the incoming request.
		 * It should have a role e.g: only admin can perform POST operation on an event. ** is wild card means match anything
		 */
		http.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.POST, "/events").hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, "/events/**").hasRole("ADMIN").antMatchers(HttpMethod.PATCH, "/events/**")
		.hasRole("ADMIN").and().csrf().disable();
	}
}
