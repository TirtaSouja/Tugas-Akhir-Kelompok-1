package com.apap.tugasakhir.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.Model.KebutuhanModel;
import com.apap.tugasakhir.Repository.KebutuhanDB;

@Service
@Transactional
public class KebutuhanServiceImpl implements KebutuhanService {
	@Autowired
	private KebutuhanDB kebDB;
	
	@Override
	public void addKebutuhan(KebutuhanModel keb) {
		kebDB.save(keb);		
	}

	@Override
	public List<KebutuhanModel> getAllData() {
		return kebDB.findAll();
	}

	@Override
	public Optional<KebutuhanModel> getKebDetailById(long id) {
		return kebDB.findById(id);
	}

	@Override
	public KebutuhanModel getKebById(long id) {
		return kebDB.findKebById(id);
	}

	@Override
	public void updateKebutuhan(KebutuhanModel kebModel) {
		kebDB.save(kebModel);
		
	}

	@Override
	public List<KebutuhanModel> getAllPlan() {
		return kebDB.findAll();
	}

}
