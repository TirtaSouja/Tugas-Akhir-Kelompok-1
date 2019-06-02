package com.apap.tugasakhir.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugasakhir.Model.PemeriksaanModel;


@Repository
public interface PemeriksaanDB extends JpaRepository<PemeriksaanModel, Long> {

	PemeriksaanModel findReqById(long id);

}
