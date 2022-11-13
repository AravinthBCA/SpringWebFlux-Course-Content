package StudentManagement.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import StudentManagement.entity.User;
import StudentManagement.entity.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
