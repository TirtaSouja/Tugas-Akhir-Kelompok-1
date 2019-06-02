package com.apap.tugasakhir.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.tugasakhir.Model.KebutuhanModel;

@Transactional
@Repository
public interface KebutuhanDB extends JpaRepository<KebutuhanModel, Long> {
	public List<KebutuhanModel> findAll();
	KebutuhanModel findKebById(long id);
}