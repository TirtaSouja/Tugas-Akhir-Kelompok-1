package com.apap.tugasakhir.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugasakhir.Model.SuppliesModel;
import com.apap.tugasakhir.Service.SuppliesService;

@Controller
public class SuppliesController {
	@Autowired
	private SuppliesService supService;
	
	@RequestMapping(value = "/lab/stok", method = RequestMethod.GET)
	private String stok(Model model) {
		model.addAttribute("stockList", supService.getAllData());
		model.addAttribute("found", true);
		return "view-stock";
	}
	
	@RequestMapping(value = "/lab/stok/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("stok", new SuppliesModel());
		return "addStockForm";
	}
	
	@RequestMapping(value = "/lab/stok/tambah", method = RequestMethod.POST)
	private String addStockSubmit(@ModelAttribute SuppliesModel stok, Model model) {
		supService.addStock(stok);
		model.addAttribute("idStc", stok.getId());
		model.addAttribute("jenisStc", stok.getJenis());
		model.addAttribute("namaStc", stok.getNama());
		model.addAttribute("jmlStc", stok.getJumlah());
		model.addAttribute("descStc", stok.getDeskripsi());
		return "submitStocks";
	}
	
	@RequestMapping(value = "/lab/stok/ubah/{id}", method = RequestMethod.GET)
    private String updateStock(@PathVariable("id") long id, Model model) {
		SuppliesModel stock = supService.getStockById(id);
		model.addAttribute("id", stock.getId());
		model.addAttribute("jenis", stock.getJenis());
		model.addAttribute("nama", stock.getNama());
		model.addAttribute("jumlah", stock.getJumlah());
		model.addAttribute("deskripsi", stock.getDeskripsi());
		return "update-stock";
    }
	
	@RequestMapping(value = "/lab/stok/ubah", method = RequestMethod.POST)
	public String updateStockSubmit(@RequestParam("id") long id,
			@RequestParam("jenis") String jenis_stc,
    		@RequestParam("nama") String nama_stc,
    		@RequestParam("jumlah") int jml_stc,
    		@RequestParam("deskripsi") String desc_stc,
    		@ModelAttribute SuppliesModel stock, Model model) {
		SuppliesModel stcModel = supService.getStockById(id);
		stcModel.setJenis(jenis_stc);
		stcModel.setNama(nama_stc);
		stcModel.setJumlah(jml_stc);
		stcModel.setDeskripsi(desc_stc);
		supService.updateStock(stcModel);
		model.addAttribute("idStc", stock.getId());
		model.addAttribute("jenisStc", stock.getJenis());
		model.addAttribute("namaStc", stock.getNama());
		model.addAttribute("jmlStc", stock.getJumlah());
		model.addAttribute("descStc", stock.getDeskripsi());
		return "updateStocks";
	}
}
