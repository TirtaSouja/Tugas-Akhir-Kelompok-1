package com.example.demo.Model;

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
@Table(name = "tbl_jenis_pemeriksaan")
public class JenisPemeriksaanModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Size(max=255)
    @Column(name = "nama", nullable = false)
    private String nama;

    @JoinColumn(name = "id_supplies", referencedColumnName = "id")
    private int suppliesId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getSuppliesId() {
		return suppliesId;
	}

	public void setSuppliesId(int suppliesId) {
		this.suppliesId = suppliesId;
	}
}
