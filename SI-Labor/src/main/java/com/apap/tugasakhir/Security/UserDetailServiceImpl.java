package com.apap.tugasakhir.Security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apap.tugasakhir.Model.UserModel;
import com.apap.tugasakhir.Repository.UserDB;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserDB userDB;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userDB.findByUsername(username);
		
		Set<GrantedAuthority> ga = new HashSet<GrantedAuthority>();
		ga.add(new SimpleGrantedAuthority(user.getRole()));
		
		return new User(user.getUsername(), user.getPassword(), ga);
	}
	
}
