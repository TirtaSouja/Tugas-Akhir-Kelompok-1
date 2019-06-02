package com.apap.tugasakhir.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tugasakhir.Model.JadwalModel;
import com.apap.tugasakhir.Repository.JadwalDB;

@Service
@Transactional
public class JadwalServiceImpl implements JadwalService {
	@Autowired
	private JadwalDB scheDB;
	
	@Override
	public List<JadwalModel> getAllData() {
		return scheDB.findAll();
	}

	@Override
	public JadwalModel getScheById(long id) {
		return scheDB.findScheById(id);
	}

	@Override
	public void updateSchedule(JadwalModel scheModel) {
		scheDB.save(scheModel);
	}

	@Override
	public void addSched(JadwalModel sched) {
		scheDB.save(sched);
	}
}
