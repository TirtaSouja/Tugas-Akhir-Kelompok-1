package com.apap.tugasakhir.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.Model.StaffModel;
import com.apap.tugasakhir.Repository.StaffDB;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffDB staffDB;
	
	@Override
	public List<StaffModel> getAllData() {
		return staffDB.findAll();
	}

	@Override
	public StaffModel getNamaByid(long staffId) {
		return staffDB.findNamaById(staffId);
	}

}
