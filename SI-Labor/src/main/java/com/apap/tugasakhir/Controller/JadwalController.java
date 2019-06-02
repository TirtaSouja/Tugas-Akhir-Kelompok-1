package com.apap.tugasakhir.Controller;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tugasakhir.Model.JadwalModel;
import com.apap.tugasakhir.Model.StaffModel;
import com.apap.tugasakhir.Service.JadwalService;
import com.apap.tugasakhir.Service.StaffService;

@Controller
public class JadwalController {
	@Autowired
	private JadwalService scheService;
	
	@Autowired
	private StaffService staffService;
	
	@RequestMapping(value = "/lab/jadwal-jaga", method = RequestMethod.GET)
	private String jadwal(Model model) {
		model.addAttribute("scheList", scheService.getAllData());
		model.addAttribute("found", true);
		return "view-schedule";
	}
	
	@RequestMapping(value = "/lab/jadwal-jaga/tambah", method = RequestMethod.GET)
	private String add(Model model) {
		List<StaffModel> staffModel = staffService.getAllData();
		model.addAttribute("staffModel", staffModel);
		model.addAttribute("jadwal", new JadwalModel());
		return "addScheForm";
	}
	
	@RequestMapping(value = "/lab/jadwal-jaga/tambah", method = RequestMethod.POST)
	private String addScheSubmit(@ModelAttribute JadwalModel sched, Model model) {
		scheService.addSched(sched);
		StaffModel staffM = staffService.getNamaByid(sched.getStaffId());
		model.addAttribute("idSche", sched.getId());
		model.addAttribute("tglSche", sched.getTanggal());
		model.addAttribute("namaSche", staffM.getNama());
		model.addAttribute("mulaiSche", sched.getWaktuMulai());
		model.addAttribute("selesaiSche", sched.getWaktuSelesai());
		return "submitScheds";
	}
	
	@RequestMapping(value = "/lab/jadwal-jaga/ubah/{id}", method = RequestMethod.GET)
    private String updateSche(@PathVariable("id") long id, Model model) {
        JadwalModel sch = scheService.getScheById(id);
        StaffModel staffM = staffService.getNamaByid(sch.getStaffId());
        List<StaffModel> staffModel = staffService.getAllData();
		model.addAttribute("staffModel", staffModel);
        model.addAttribute("idSche", id);
		model.addAttribute("tglSche", sch.getTanggal());
		model.addAttribute("mulaiSche", sch.getWaktuMulai());
		model.addAttribute("selesaiSche", sch.getWaktuSelesai());
		model.addAttribute("namaSche", staffM.getNama());
		return "update-jadwal-jaga";
    }
	
	@RequestMapping(value = "/lab/jadwal-jaga/ubah", method = RequestMethod.POST)
	public String updateScheSubmit(@RequestParam("idSche") long id,
			@RequestParam("tanggal") Date tgl_sche,
    		@RequestParam("waktuMulai") String mulai_sche,
    		@RequestParam("waktuSelesai") String selesai_sche,
    		@RequestParam("staffId") long nama_sche,
    		@ModelAttribute JadwalModel sch, Model model) {
		JadwalModel scheModel = scheService.getScheById(id);
		StaffModel staffM = staffService.getNamaByid(scheModel.getStaffId());
		scheModel.setTanggal(tgl_sche);
		scheModel.setWaktuMulai(mulai_sche);
		scheModel.setWaktuSelesai(selesai_sche);
		scheModel.setStaffId(nama_sche);
		scheService.updateSchedule(scheModel);
		model.addAttribute("idSche", scheModel.getId());
		model.addAttribute("tglSche", scheModel.getTanggal());
		model.addAttribute("mulaiSche", scheModel.getWaktuMulai());
		model.addAttribute("selesaiSche", scheModel.getWaktuSelesai());
		model.addAttribute("namaSche", staffM.getNama());
		return "updateSchedules";
	}
}
