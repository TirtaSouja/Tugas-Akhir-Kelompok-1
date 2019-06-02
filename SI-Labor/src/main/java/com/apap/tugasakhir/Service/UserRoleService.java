package com.apap.tugasakhir.Service;

import com.apap.tugasakhir.Model.UserModel;

public interface UserRoleService {
	UserModel addUser(UserModel user);
	public String encrypt(String password);
}
