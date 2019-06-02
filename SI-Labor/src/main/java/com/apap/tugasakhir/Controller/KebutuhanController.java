package com.apap.tugasakhir.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugasakhir.Model.KebutuhanModel;
import com.apap.tugasakhir.Model.SuppliesModel;
import com.apap.tugasakhir.Service.KebutuhanService;
import com.apap.tugasakhir.Service.SuppliesService;

@Controller
public class KebutuhanController {
	@Autowired
	private KebutuhanService kebService;
	
	@Autowired
	private SuppliesService supService;
	
	@RequestMapping(value = "/lab", method = RequestMethod.GET)
	private String lab(Model model) {
		model.addAttribute("kebList", kebService.getAllData());
		model.addAttribute("found", true);
		return "kebutuhan";
	}
	
	@RequestMapping(value = "/lab/kebutuhan", method = RequestMethod.GET)
	private String permintaan(Model model) {
		model.addAttribute("kebList", kebService.getAllData());
		model.addAttribute("found", true);
		return "view-reagen";
	}
	
	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		List<SuppliesModel> supModel = supService.getAllData();
		model.addAttribute("supModel", supModel);
		model.addAttribute("kebutuhan", new KebutuhanModel());
		return "addKebForm";
	}
	
	@RequestMapping(value = "/lab/kebutuhan/tambah", method = RequestMethod.POST)
	private String addKebSubmit(@ModelAttribute KebutuhanModel kebutuhan, Model model) {
		kebService.addKebutuhan(kebutuhan);
		model.addAttribute("id", kebutuhan.getId());
		model.addAttribute("idReagen", kebutuhan.getReagenId().getId());
		model.addAttribute("jumlah", kebutuhan.getJumlah());
		model.addAttribute("status", kebutuhan.getStatus());
		model.addAttribute("tanggal", kebutuhan.getTanggalUpdate());
		return "submitKebs";
	}
	
	@RequestMapping(value = "/lab/kebutuhan/ubah/{id}", method = RequestMethod.GET)
    private String updateKeb(@PathVariable("id") long id, Model model) {
        KebutuhanModel keb = kebService.getKebById(id);
        model.addAttribute("id", id);
		return "update-kebutuhan";
    }
	
	@RequestMapping(value = "/lab/kebutuhan/ubah", method = RequestMethod.POST)
	public String updateKebSubmits(@RequestParam("id") long id,
			@RequestParam("status") long status,
    		@ModelAttribute KebutuhanModel kebutuhan, Model model) {
		KebutuhanModel kebModel = kebService.getKebById(id);
		kebModel.setStatus(status);
		kebService.updateKebutuhan(kebModel);
		model.addAttribute("id", kebModel.getId());
		model.addAttribute("idReagen", kebModel.getReagenId().getId());
		model.addAttribute("jumlah", kebModel.getJumlah());
		model.addAttribute("status", kebModel.getStatus());
		model.addAttribute("tanggal", kebModel.getTanggalUpdate());
		return "updateKebs";
	}
}
