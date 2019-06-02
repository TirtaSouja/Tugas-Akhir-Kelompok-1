package com.apap.tugasakhir.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apap.tugasakhir.Model.JadwalModel;

public interface JadwalDB extends JpaRepository<JadwalModel, Long> {

	JadwalModel findScheById(long id);

}
