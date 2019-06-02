package com.apap.tugasakhir.Service;

import java.util.List;

import com.apap.tugasakhir.Model.JadwalModel;

public interface JadwalService {

	List<JadwalModel> getAllData();

	JadwalModel getScheById(long id);

	void updateSchedule(JadwalModel scheModel);

	void addSched(JadwalModel sched);

}
