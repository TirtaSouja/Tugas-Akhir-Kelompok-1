package com.apap.tugasakhir.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apap.tugasakhir.Model.UserModel;
import com.apap.tugasakhir.Repository.UserDB;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserDB userDB;

	@Override
	public UserModel addUser(UserModel user) {
		String pass = encrypt(user.getPassword());
		user.setPassword(pass);
		return userDB.save(user);
	}

	@Override
	public String encrypt(String password) {
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		String hashPass = pe.encode(password);
		return hashPass;
	}

}
