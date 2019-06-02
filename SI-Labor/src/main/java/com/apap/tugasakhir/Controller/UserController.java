package com.apap.tugasakhir.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apap.tugasakhir.Model.UserModel;
import com.apap.tugasakhir.Service.UserRoleService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRoleService userService;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	private String addUserSubmit(@ModelAttribute UserModel user) {
		userService.addUser(user);
		return "home";
	}
}
