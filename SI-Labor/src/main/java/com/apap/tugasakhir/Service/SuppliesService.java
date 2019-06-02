package com.apap.tugasakhir.Service;

import java.util.List;

import com.apap.tugasakhir.Model.SuppliesModel;

public interface SuppliesService {

	List<SuppliesModel> getAllData();
	void addStock(SuppliesModel stok);
	SuppliesModel getStockById(long id);
	void updateStock(SuppliesModel stcModel);

}
