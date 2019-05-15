package com.example.demo.Model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_kebutuhan")
public class KebutuhanModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@NotNull
    @Column(name = "tanggal_update", nullable = false)
    private Date tanggalUpdate;

    @NotNull
    @Column(name = "jumlah", nullable = false)
    private int jumlah;
    
    @NotNull
    @Column(name = "status", nullable = false)
    private int status;
    
    @JoinColumn(name = "id_reagen", referencedColumnName = "id")
    private int reagenId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTanggalUpdate() {
		return tanggalUpdate;
	}

	public void setTanggalUpdate(Date tanggalUpdate) {
		this.tanggalUpdate = tanggalUpdate;
	}

	public int getJumlah() {
		return jumlah;
	}

	public void setJumlah(int jumlah) {
		this.jumlah = jumlah;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getReagenId() {
		return reagenId;
	}

	public void setReagenId(int reagenId) {
		this.reagenId = reagenId;
	}
}
