package StudentManagement.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import StudentManagement.entity.Role;
import StudentManagement.entity.User;
import StudentManagement.entity.UserRegistrationDto;
import StudentManagement.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
//		if(registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
//			
//		}
		User user = new User(registrationDto.getEmail(),passwordEncoder.encode(registrationDto.getPassword()), 
								Arrays.asList(new Role("ROLE_ADMIN")));
		
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> userList = userRepository.findAll();
		System.out.println("Logs ----> Login Username : "+username);
		User user = null;
		for(User i : userList) {
			System.out.println("Logs ----> Database Username : "+i.getEmail());
			if(i.getEmail().equals(username)) {
				user = i;
				break;
			}
		}
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));		
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<StudentManagement.entity.Role> collection){
		return collection.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
}
