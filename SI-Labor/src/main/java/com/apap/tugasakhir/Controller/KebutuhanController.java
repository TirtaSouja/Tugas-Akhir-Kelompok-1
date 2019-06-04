package com.apap.tugasakhir.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apap.tugasakhir.Model.KebutuhanModel;
import com.apap.tugasakhir.Model.SuppliesModel;
import com.apap.tugasakhir.Service.KebutuhanService;
import com.apap.tugasakhir.Service.SuppliesService;

@Controller
@RequestMapping("/lab")
public class KebutuhanController {
	@Autowired
	private KebutuhanService kebService;
	
	@Autowired
	private SuppliesService supService;
	
	@GetMapping(value = "/kebutuhan/perencanaan")
    private List<KebutuhanModel> kebViewAll(@ModelAttribute KebutuhanModel kebModel) {
        return kebService.getAllPlan();
    }
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	private String lab(Model model) {
		model.addAttribute("kebList", kebService.getAllData());
		model.addAttribute("found", true);
		return "kebutuhan";
	}
	
	@GetMapping(value = "/kebutuhan")
	private String permintaan(Model model) {
		model.addAttribute("kebList", kebService.getAllData());
		model.addAttribute("found", true);
		return "view-reagen";
	}
	
	@RequestMapping(value = "/kebutuhan/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		List<SuppliesModel> supModel = supService.getAllData();
		model.addAttribute("supModel", supModel);
		model.addAttribute("kebutuhan", new KebutuhanModel());
		return "addKebForm";
	}
	
	@RequestMapping(value = "/kebutuhan/tambah", method = RequestMethod.POST)
	private String addKebSubmit(@ModelAttribute KebutuhanModel kebutuhan, Model model) {
		kebService.addKebutuhan(kebutuhan);
		model.addAttribute("id", kebutuhan.getId());
		model.addAttribute("idReagen", kebutuhan.getReagenId().getId());
		model.addAttribute("jumlah", kebutuhan.getJumlah());
		model.addAttribute("status", kebutuhan.getStatus());
		model.addAttribute("tanggal", kebutuhan.getTanggalUpdate());
		return "submitKebs";
	}
	
	@RequestMapping(value = "/kebutuhan/ubah/{id}", method = RequestMethod.GET)
    private String updateKeb(@PathVariable("id") long id, Model model) {
        KebutuhanModel keb = kebService.getKebById(id);
        model.addAttribute("id", id);
		return "update-kebutuhan";
    }
	
	@RequestMapping(value = "/kebutuhan/ubah", method = RequestMethod.POST)
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
