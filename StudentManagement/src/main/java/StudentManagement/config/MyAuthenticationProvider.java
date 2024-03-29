package StudentManagement.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		if("aravinth".equals(userName) && "password".equals(password)) {
			Collection<String> list = new ArrayList<String>();
			list.add("Admin");
			return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
		}
		else {
			throw new BadCredentialsException("Invalid Username or Password");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
