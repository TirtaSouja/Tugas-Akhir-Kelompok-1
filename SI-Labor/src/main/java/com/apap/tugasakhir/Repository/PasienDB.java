package com.apap.tugasakhir.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugasakhir.Model.PasienModel;

public interface PasienDB extends JpaRepository<PasienModel, Long> {
	public List<PasienModel> findAll();

	public PasienModel findNamaById(long pasienId);
}
