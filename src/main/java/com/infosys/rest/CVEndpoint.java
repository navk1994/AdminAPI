package com.infosys.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.db.CV;
import com.infosys.repository.CVRepository;

@RestController

@RequestMapping("/cv")
public class CVEndpoint {

	@Autowired
	private CVRepository cvRepository;

	@PostMapping("/add")
	public String addCV() {
		CV cv = new CV();
		cv.setUserID(1);
		cv.setCvPath("C:\\Users\\Admin\\Desktop\\test.txt");
		cvRepository.save(cv);
		return "Saved the Cv";
	}

	@RequestMapping("/getcv")
	public void getCV() {
		//File file = new File("C:\\Users\\Admin\\Desktop\\test.txt");

	
		
	}

	@RequestMapping("/test")
	public String test() {
		return "The API works";
	}
	
	@RequestMapping(value = "downloadTestFile", method = RequestMethod.GET)
	public void getSteamingFile1(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=\"test.pdf\"");
		InputStream inputStream = new FileInputStream(new File("C:\\Users\\Admin\\Desktop\\Don.pdf"));
		   int nRead;
		   while ((nRead = inputStream.read()) != -1) {
		       response.getWriter().write(nRead);
		   }
		}
	

}
