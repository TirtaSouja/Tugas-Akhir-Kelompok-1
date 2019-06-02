package com.apap.tugasakhir.Service;

import java.util.List;

import com.apap.tugasakhir.Model.PasienModel;

public interface PasienService {
	List<PasienModel> getAllData();
	PasienModel getNamaByid(long pasienId);
}
