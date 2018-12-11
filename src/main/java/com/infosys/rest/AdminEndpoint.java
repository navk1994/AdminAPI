package com.infosys.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.constants.Constants;
import com.infosys.db.Admin;
import com.infosys.db.CV;
import com.infosys.service.AdminService;

@RestController

@RequestMapping("/admin")
public class AdminEndpoint {

	@Autowired
	private AdminService adminService;
	
	@GetMapping("/test") //used to test if the api is functioning
	public String test() {
		return "The API is working";
	}
	
	@PostMapping("/add")
	public Admin addAdmin(@RequestBody Admin admin) {
		return adminService.addAdmin(admin);
	}
	
	@GetMapping("/get/{id}")
	public Optional<Admin> getAdmin(@PathVariable int id) {
		return adminService.getAdmin(id);
	}
	
	@GetMapping("/getall")
	public Iterable<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	@PostMapping("/update/{id}")
	public Admin updateAdminPassword(@RequestBody Admin admin, @PathVariable int id)
	{
		return adminService.updateAdminPassword(id, admin);
	}
	
	@RequestMapping("/remove/{id}")
	public String removeAdmin(@PathVariable int id) 
	{
		adminService.removeAdmin(id);
		return Constants.ADMIN_DELETED;
	}
	
	
	@GetMapping("/getallcvs")
	public Iterable<CV> getAllCVs()
	{
		return adminService.getAllCVs();
	} 
	
	
}
