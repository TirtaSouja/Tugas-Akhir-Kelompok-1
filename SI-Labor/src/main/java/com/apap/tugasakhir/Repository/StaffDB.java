package com.apap.tugasakhir.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugasakhir.Model.StaffModel;

public interface StaffDB extends JpaRepository<StaffModel, Long> {
	public List<StaffModel> findAll();

	public StaffModel findNamaById(long staffId);
}
