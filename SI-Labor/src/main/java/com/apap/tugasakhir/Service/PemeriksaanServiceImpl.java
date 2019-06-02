package com.apap.tugasakhir.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.Model.PemeriksaanModel;
import com.apap.tugasakhir.Repository.PemeriksaanDB;

@Service
@Transactional
public class PemeriksaanServiceImpl implements PemeriksaanService {

	@Autowired
	private PemeriksaanDB periksaDb;
	
	@Override
	public List<PemeriksaanModel> getAllData() {
		return periksaDb.findAll();
	}

	@Override
	public PemeriksaanModel addPemeriksaan(PemeriksaanModel req) {
		return periksaDb.save(req);
	}

	@Override
	public PemeriksaanModel getReqById(long id) {
		return periksaDb.findReqById(id);
	}

}
