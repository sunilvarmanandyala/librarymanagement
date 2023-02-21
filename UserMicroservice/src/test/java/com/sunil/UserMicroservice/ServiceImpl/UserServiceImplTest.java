package com.sunil.UserMicroservice.ServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sunil.UserMicroservice.Entity.User;
import com.sunil.UserMicroservice.Repository.UserRepository;

@SpringBootTest

@TestInstance(Lifecycle.PER_CLASS)
class UserServiceImplTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private User user;
	@BeforeAll
	void setup() {
		userServiceImpl = new UserServiceImpl() ;
		userRepository = mock(UserRepository.class);
		userServiceImpl.userRepository = userRepository;
		user = new User(1, "pavan","varma","9951235979");
	}
	@Test
	@DisplayName("saving existing user")
	void testSaveuser1 () {
		String userPhNo = user.getUserPhNo();
		when(userRepository.findByUserPhNo(userPhNo)).thenReturn(user);
		Exception thrown = assertThrows(Exception.class, () -> userServiceImpl.saveUser(user));
		assertEquals("user data already exists",thrown.getMessage());
	}
	@Test
	@DisplayName("saving new user")
	void testSaveUser2() throws Exception {
		String userPhNo = user.getUserPhNo();
		when(userRepository.findByUserPhNo(userPhNo)).thenReturn(null);
		when(userRepository.save(user)).thenReturn(user);
		
		assertEquals(user, userServiceImpl.saveUser(user));
	}
}
		