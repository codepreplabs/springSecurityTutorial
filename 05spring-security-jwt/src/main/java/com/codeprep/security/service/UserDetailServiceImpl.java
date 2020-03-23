package com.codeprep.security.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.codeprep.security.entity.User;
import com.codeprep.security.model.UserDetailsImpl;
import com.codeprep.security.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepo.getByUsername(username);
		if (user != null) {
			return populateUserDetails(user);
		} else {
			throw new UsernameNotFoundException("for user with username: " + username);
		}
	}

	private UserDetails populateUserDetails(User user) {
		
		return new UserDetailsImpl(user.getUsername(), user.getPassword(), getRoles(Arrays.asList(user.getRoles().split("\\s*,\\s*"))));
	}

	private List<GrantedAuthority> getRoles(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(!CollectionUtils.isEmpty(roles)) {
			for (String role : roles) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
		}
		return authorities;
	}

}
