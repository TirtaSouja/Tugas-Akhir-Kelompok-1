package com.apap.tugasakhir.Service;

import java.util.List;

import com.apap.tugasakhir.Model.StaffModel;

public interface StaffService {
	List<StaffModel> getAllData();

	StaffModel getNamaByid(long staffId);
}
