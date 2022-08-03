package com.demo.BookMyShowDemo;

import com.demo.BookMyShowDemo.Entity.User;
import com.demo.BookMyShowDemo.Repository.UserRepository;
import com.demo.BookMyShowDemo.Requests.UserRequest;
import com.demo.BookMyShowDemo.Services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookMyShowDemoApplicationTests {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;
	@Test
	@Order(1)
	public void saveUser() {
		User user=new User(1,"Baburao","baburao@ayu.health");
		when(userRepository.save(user)).thenReturn(user);
		Assertions.assertEquals(user,userService.adduser(user));
		Assertions.assertEquals(user.getEmail(),"baburao@ayu.health");
	}
	@Test
	@Order(2)
	public void saveUser1() {
		User user=new User(1,"Baburao","baburao@ayu.health");
		when(userRepository.save(user)).thenReturn(user);
		Assertions.assertEquals(user,userService.adduser(user));
		Assertions.assertEquals(user.getEmail(),"baburao@ayu.health");
	}
}
