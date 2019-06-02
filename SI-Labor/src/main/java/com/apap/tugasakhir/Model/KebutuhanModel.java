package com.apap.tugasakhir.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_kebutuhan")
public class KebutuhanModel implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tanggal_update")
	private Date tanggalUpdate;
	
//	@Column(name = "tanggal_update", nullable = true)
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date tanggalUpdate;

    @NotNull
    @Column(name = "jumlah", nullable = false)
    private int jumlah;
    
    @Column(name = "status", nullable = true)
    private long status = 1;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_reagen")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private SuppliesModel reagenId;

	public SuppliesModel getReagenId() {
		return reagenId;
	}

	public void setReagenId(SuppliesModel reagenId) {
		this.reagenId = reagenId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}
}
