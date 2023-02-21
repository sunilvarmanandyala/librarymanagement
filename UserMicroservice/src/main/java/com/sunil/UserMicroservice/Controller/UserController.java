package com.sunil.UserMicroservice.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sunil.UserMicroservice.Entity.User;

import com.sunil.UserMicroservice.ServiceImpl.UserServiceImpl;




@RestController
@CrossOrigin
public class UserController {
	private RestTemplate restTemp;
    @Autowired
    public UserController(RestTemplateBuilder builder) {
        this.restTemp = builder.build();
    }
    
	@Autowired
	private UserServiceImpl userService;
	@PostMapping("/useradd") //Create User Details
	public User saveUser(@RequestBody User user) throws Exception
	{
		return userService.saveUser(user);
	}
	
	
	@GetMapping("/Getuser") // Get User Details
	public List<User> fetchUserList()
	{
		return userService.fetchUserList();
	}
	@GetMapping("/user/{id}") //Get User Details by userI Id
	public User fetchUserById(@PathVariable("id") Integer user_Id)
	{
		return userService.fetchUserById(user_Id);
	}
	@PutMapping("/user/{id}") //update user Details by user id
	public User updateUser(@PathVariable("id") Integer user_Id,@RequestBody User user)
	{
		return userService.updateUser(user_Id, user);
	}
	@GetMapping("/user/name/{name}") //Get user details by user Name
	public User fetchByusername(@PathVariable("name") String username)
	{
		return userService.fetchByusername(username);
	}
	@DeleteMapping("/user/{user_Id}") //delete user details by user id
	public void deleteUserById(@PathVariable("user_Id") Integer user_Id)
	{
		userService.deleteUserById(user_Id);
	}
}