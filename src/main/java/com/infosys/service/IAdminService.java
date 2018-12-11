package com.infosys.service;

import com.infosys.db.Admin;
import com.infosys.db.CV;

public interface IAdminService {
	
	public Admin addAdmin(Admin admin);
	
	public String removeAdmin(int id);
	
	public Admin updateAdminPassword(int id, Admin admin);
	
	public Iterable<Admin> getAllAdmins();
	
	public Iterable<CV> getAllCVs();
	
	
}
