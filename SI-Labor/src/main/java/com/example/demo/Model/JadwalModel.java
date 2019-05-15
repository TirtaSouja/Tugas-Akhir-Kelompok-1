package com.example.demo.Model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_jadwal")
public class JadwalModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "tanggal", nullable = false)
    private Date tanggal;

    @NotNull
    @Column(name = "waktu_mulai", nullable = false)
    private Time waktuMulai;

    @NotNull
    @Column(name = "waktu_selesai", nullable = false)
    private Time waktuSelesai;

    @JoinColumn(name = "id_staff", referencedColumnName = "id")
    private int staffId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public Time getWaktuMulai() {
		return waktuMulai;
	}

	public void setWaktuMulai(Time waktuMulai) {
		this.waktuMulai = waktuMulai;
	}

	public Time getWaktuSelesai() {
		return waktuSelesai;
	}

	public void setWaktuSelesai(Time waktuSelesai) {
		this.waktuSelesai = waktuSelesai;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
}
