package com.apap.tugasakhir.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugasakhir.Model.UserModel;

@Repository
public interface UserDB extends JpaRepository<UserModel, Long> {
	UserModel findByUsername(String username);
}
