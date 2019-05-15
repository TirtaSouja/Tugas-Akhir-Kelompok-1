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
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_pemeriksaan")
public class PemeriksaanModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	@NotNull
    @Column(name = "tanggal_pengajuan", nullable = false)
    private Date tanggalPengajuan;
	
	@JoinColumn(name = "pasien", referencedColumnName = "id")
    private int pasienId;
	
	@NotNull
    @Column(name = "tanggal_pemeriksaan", nullable = false)
    private Date tanggalPemeriksaan;
	
	@JoinColumn(name = "jenis", referencedColumnName = "id")
    private int jenisId;
	
	@JoinColumn(name = "id_jadwal", referencedColumnName = "id")
    private int jadwalId;
	
	@NotNull
    @Column(name = "status", nullable = false)
    private int status;
	
    @NotNull
    @Size(max=255)
    @Column(name = "hasil", nullable = false)
    private String hasil;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}

	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
	}

	public int getPasienId() {
		return pasienId;
	}

	public void setPasienId(int pasienId) {
		this.pasienId = pasienId;
	}

	public Date getTanggalPemeriksaan() {
		return tanggalPemeriksaan;
	}

	public void setTanggalPemeriksaan(Date tanggalPemeriksaan) {
		this.tanggalPemeriksaan = tanggalPemeriksaan;
	}

	public int getJenisId() {
		return jenisId;
	}

	public void setJenisId(int jenisId) {
		this.jenisId = jenisId;
	}

	public int getJadwalId() {
		return jadwalId;
	}

	public void setJadwalId(int jadwalId) {
		this.jadwalId = jadwalId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getHasil() {
		return hasil;
	}

	public void setHasil(String hasil) {
		this.hasil = hasil;
	}
}
