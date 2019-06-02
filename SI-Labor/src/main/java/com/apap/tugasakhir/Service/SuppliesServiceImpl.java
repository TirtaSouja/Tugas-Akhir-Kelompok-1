package com.apap.tugasakhir.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.Model.SuppliesModel;
import com.apap.tugasakhir.Repository.SuppliesDB;

@Service
@Transactional
public class SuppliesServiceImpl implements SuppliesService {
	@Autowired
	private SuppliesDB suppDB;
	
	@Override
	public List<SuppliesModel> getAllData() {
		return suppDB.findAll();
	}

	@Override
	public void addStock(SuppliesModel stok) {
		suppDB.save(stok);
	}

	@Override
	public SuppliesModel getStockById(long id) {
		return suppDB.findStockById(id);
	}

	@Override
	public void updateStock(SuppliesModel stcModel) {
		suppDB.save(stcModel);
	}
}
