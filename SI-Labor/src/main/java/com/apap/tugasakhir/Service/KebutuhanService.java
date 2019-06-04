package com.apap.tugasakhir.Service;

import java.util.List;
import java.util.Optional;

import com.apap.tugasakhir.Model.KebutuhanModel;

public interface KebutuhanService {

	void addKebutuhan(KebutuhanModel keb);

	List<KebutuhanModel> getAllData();

	Optional<KebutuhanModel> getKebDetailById(long id);

	KebutuhanModel getKebById(long id);

	void updateKebutuhan(KebutuhanModel kebModel);

	List<KebutuhanModel> getAllPlan();
}
