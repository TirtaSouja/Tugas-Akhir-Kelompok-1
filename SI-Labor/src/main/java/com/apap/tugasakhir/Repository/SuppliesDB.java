package com.apap.tugasakhir.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugasakhir.Model.SuppliesModel;

@Repository
public interface SuppliesDB extends JpaRepository<SuppliesModel, Long> {

	SuppliesModel findStockById(long id);

}
