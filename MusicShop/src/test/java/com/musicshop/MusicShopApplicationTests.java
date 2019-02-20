package com.musicshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.musicshop.entities.User;
import com.musicshop.services.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MusicShopApplicationTests {
	
	
	@Autowired
	private UserService userService;
	
	@org.junit.Before
	public void initDb() {
		{
		User newUser = new User("testUser@name.com", "testUser", "123456");
		userService.createUser(newUser);
		}
		
		{
			User newUser = new User("testAdmin@name.com", "testAdmin", "123456");
			userService.createUser(newUser);
		}
		
		User user = userService.findByEmail("testUser@name.com");
	}
	
	@Test
	public void testUser() {
		User user = userService.findByEmail("testUser@name.com");
		assertNotNull(user);
		User admin = userService.findByEmail("testAdmin@name.com");
		assertEquals(admin.getEmail(), "testAdmin@name.com");
	}
	
}
