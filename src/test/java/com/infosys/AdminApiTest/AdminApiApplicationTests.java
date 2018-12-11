package com.infosys.AdminApiTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.infosys.constants.Constants;
import com.infosys.db.Admin;
import com.infosys.repository.AdminRepository;
import com.infosys.service.AdminService;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminApiApplicationTests {

	@InjectMocks
	private AdminService service;

	@Mock
	private AdminRepository adminrepo;

	@Mock
	private Admin admin;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testAddAdmin() {
		Mockito.when(service.addAdmin(admin)).thenReturn(admin);
		assertThat(admin, is(notNullValue()));
	}

	@Test
	public void testRemoveAdmin() {

		// Assert.assertEquals(Constants.ADMIN_DELETED,
		// service.removeAdmin(admin.getAdminID()));
		assertEquals(Constants.ADMIN_DELETED, service.removeAdmin(admin.getAdminID()));
		assertEquals(Optional.empty(), service.getAdmin(admin.getAdminID()));
	}
	
	@Test 
	public void testUpdateAdminPassword() {
		admin.setPassword("Test password");
		
		Mockito.when(service.updateAdminPassword(admin.getAdminID(), admin)).thenReturn(admin);
		
		String actual = admin.getPassword();
		
		assertEquals("Test password", actual);
	}

	@Test
	public void testGetAdmin() {
		Mockito.when(service.getAdmin(admin.getAdminID())).thenReturn(Optional.of(admin));
		assertEquals(Optional.of(admin), service.getAdmin(admin.getAdminID()));
	}

}
