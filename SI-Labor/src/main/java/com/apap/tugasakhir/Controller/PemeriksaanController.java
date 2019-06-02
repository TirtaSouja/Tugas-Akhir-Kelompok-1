package com.apap.tugasakhir.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugasakhir.Model.JadwalModel;
import com.apap.tugasakhir.Model.PasienModel;
import com.apap.tugasakhir.Model.PemeriksaanModel;
import com.apap.tugasakhir.Model.StaffModel;
import com.apap.tugasakhir.Service.PasienService;
import com.apap.tugasakhir.Service.PemeriksaanService;
import com.apap.tugasakhir.Service.StaffService;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

@Controller
public class PemeriksaanController {
	@Autowired
	private PemeriksaanService periksaService;
	
	@Autowired
	private PasienService pasienService;
	
	@RequestMapping(value = "/lab/pemeriksaan/permintaan", method = RequestMethod.GET)
	private String permintaan(@ModelAttribute PemeriksaanModel check, Model model) {
		List<PemeriksaanModel> lPeriksa = periksaService.getAllData();	
		if (periksaService.getAllData().isEmpty()) {
			model.addAttribute("notFound", true);
		}else {
		model.addAttribute("found", true);
		}
		model.addAttribute("lPeriksa", lPeriksa);
		model.addAttribute("cList", periksaService.getAllData());
		return "view-request";
	}
	
	@RequestMapping(value = "/lab/pemeriksaan/{id}", method = RequestMethod.GET)
    private String updateReq(@PathVariable("id") long id, Model model) {
        PemeriksaanModel req = periksaService.getReqById(id);
        List<PemeriksaanModel> lPeriksa = periksaService.getAllData();	
        if(req.getStatusId() == 1) {
        	model.addAttribute("status", 1);
        }else if(req.getStatusId() ==2) {
        	model.addAttribute("status", 2);
        }else {
        	model.addAttribute("status", 3);
        }
        model.addAttribute("idReq", id);
		model.addAttribute("statusReq", req.getStatusId());
		return "update-request";
    }
	
	@RequestMapping(value = "/lab/pemeriksaan/ubah", method = RequestMethod.POST)
	public String updateReqSubmit(@RequestParam("id") long id,
			@RequestParam("statusId") long stat_id,
    		@RequestParam(value = "hasil", required = false) String hasil,
    		@ModelAttribute PemeriksaanModel pemeriksaan, Model model) {
		PemeriksaanModel cekModel = periksaService.getReqById(id);

		cekModel.setStatusId(stat_id);
		cekModel.setHasil(hasil);
		
		model.addAttribute("id", id);
		model.addAttribute("namaPasien", cekModel.getPasienId().getNama());
		model.addAttribute("tanggalPengajuan", cekModel.getTanggalPengajuan());
		
		if(stat_id == 1) {
        	model.addAttribute("status", 1);
        }else if(stat_id == 2) {
        	model.addAttribute("status", 2);
        }else {
        	model.addAttribute("status", 3);
        }
		return "updateRequests";
	}
}
