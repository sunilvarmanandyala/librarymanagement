package com.sunil.UserMicroservice.Service;


import java.util.List;

import com.sunil.UserMicroservice.Entity.User;





public interface UserService {
	public static User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<User> fetchUserList() {
		// TODO Auto-generated method stub
		return null;
	}
	public User fetchUserById(Integer userId);
	public void deleteUserById(Integer userId);
	public User updateUser(Integer userId,User user);
	public User fetchByusername(String username);
	List<User> findByusername(String username);
}