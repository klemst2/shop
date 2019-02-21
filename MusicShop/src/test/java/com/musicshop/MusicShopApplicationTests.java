package com.musicshop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

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

		User newUser = new User("testUser@name.com", "testUser", "123456");
		userService.createUser(newUser);

		User newAdmin = new User("testAdmin@name.com", "testAdmin", "123456");
		userService.createAdmin(newAdmin);

	}

	@Test
	public void testUser() {
		Optional<User> user = userService.findByEmail("testUser@name.com");
		assertNotNull(user.get());
	}

	@Test
	public void testAdmin() {
		Optional<User> admin = userService.findByEmail("testAdmin@name.com");
		assertEquals(admin.get().getEmail(), "testAdmin@name.com");
	}

}
