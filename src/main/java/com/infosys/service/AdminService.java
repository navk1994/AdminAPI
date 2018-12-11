package com.infosys.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.constants.Constants;
import com.infosys.db.Admin;
import com.infosys.db.CV;
import com.infosys.repository.AdminRepository;
import com.infosys.repository.CVRepository;

@Service // has all the business logic that the repo uses
public class AdminService implements IAdminService {

	@Autowired
	private AdminRepository adminRepostory;

	@Autowired
	private CVRepository cvRepository;

	public Admin addAdmin(Admin admin) {
		return adminRepostory.save(admin);
	}

	public String removeAdmin(int id) {
		// TODO Auto-generated method stub
		adminRepostory.deleteById(id);
		return Constants.ADMIN_DELETED;
	}

	public Optional<Admin> getAdmin(int id) {
		return adminRepostory.findById(id);
	}

	public Iterable<Admin> getAllAdmins() {

		return adminRepostory.findAll();
	}

	public Iterable<CV> getAllCVs() {
		return cvRepository.findAll();
	}

	public Admin updateAdminPassword(int id, Admin newAdmin) {
		Optional<Admin> adminInDB = adminRepostory.findById(id);
	//	Optional<Admin> adminInDB = getAdmin(newAdmin.getAdminID());
		
		if (adminInDB.get() != null) {
			adminInDB.get().setPassword(newAdmin.getPassword());
			return adminInDB.get();
		}
		
		else {
			return newAdmin;
		}

//		Optional<Admin> adminInDB = getAdmin(newAdmin.getAdminID());
//		System.out.println(adminInDB);
//		adminInDB.get().setPassword(newAdmin.getPassword());
//		return adminInDB.get();

	}

}
