package com.apap.tugasakhir.Model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_pemeriksaan")
public class PemeriksaanModel implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tanggal_pengajuan", nullable = true)
    private Date tanggalPengajuan;
	
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "pasien_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PasienModel pasienId;
    
//	@JoinColumn(name = "pasien_id", referencedColumnName = "id")
//    private long pasienId;
	
    @Column(name = "tanggal_pemeriksaan", nullable = true)
    private Date tanggalPemeriksaan;
	
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "jenis_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JenisPemeriksaanModel jenisId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "jadwal_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private JadwalModel jadwalId;
	
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private long statusId;
	
    public long getStatusId() {
		return statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	@Size(max=255)
    @Column(name = "hasil", nullable = true)
    private String hasil;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getTanggalPengajuan() {
		return tanggalPengajuan;
	}

	public void setTanggalPengajuan(Date tanggalPengajuan) {
		this.tanggalPengajuan = tanggalPengajuan;
	}
	
	public PasienModel getPasienId() {
		return pasienId;
	}

	public void setPasienId(PasienModel pasienId) {
		this.pasienId = pasienId;
	}

	public Date getTanggalPemeriksaan() {
		return tanggalPemeriksaan;
	}

	public void setTanggalPemeriksaan(Date tanggalPemeriksaan) {
		this.tanggalPemeriksaan = tanggalPemeriksaan;
	}

	public JenisPemeriksaanModel getJenisId() {
		return jenisId;
	}

	public void setJenisId(JenisPemeriksaanModel jenisId) {
		this.jenisId = jenisId;
	}

	public JadwalModel getJadwalId() {
		return jadwalId;
	}

	public void setJadwalId(JadwalModel jadwalId) {
		this.jadwalId = jadwalId;
	}

	public String getHasil() {
		return hasil;
	}

	public void setHasil(String hasil) {
		this.hasil = hasil;
	}
}
