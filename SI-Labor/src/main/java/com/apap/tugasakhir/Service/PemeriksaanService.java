package com.apap.tugasakhir.Service;

import java.util.List;

import com.apap.tugasakhir.Model.PemeriksaanModel;

public interface PemeriksaanService {
	List<PemeriksaanModel> getAllData();

	PemeriksaanModel addPemeriksaan(PemeriksaanModel req);

	PemeriksaanModel getReqById(long id);
}
