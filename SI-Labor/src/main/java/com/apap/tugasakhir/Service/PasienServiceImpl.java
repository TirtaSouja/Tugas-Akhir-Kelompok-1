package com.apap.tugasakhir.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.Model.PasienModel;
import com.apap.tugasakhir.Repository.PasienDB;

@Service
@Transactional
public class PasienServiceImpl implements PasienService {
	@Autowired
	private PasienDB pasienDB;
	
	@Override
	public List<PasienModel> getAllData() {
		return pasienDB.findAll();
	}

	@Override
	public PasienModel getNamaByid(long pasienId) {
		return pasienDB.findNamaById(pasienId);
	}

}
