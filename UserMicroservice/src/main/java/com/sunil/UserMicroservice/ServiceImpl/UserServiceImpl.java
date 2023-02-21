package com.sunil.UserMicroservice.ServiceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.UserMicroservice.Entity.User;
import com.sunil.UserMicroservice.Repository.UserRepository;


@Service
public class UserServiceImpl {
	@Autowired
	public UserRepository userRepository;
	public User saveUser(User user) throws Exception
	{
		String userPhNo = user.getUserPhNo();
		User existingUser = userRepository.findByUserPhNo(userPhNo);
		
		if (existingUser == null) {
			return userRepository.save(user);
		}
		else {
			throw new Exception("user data already exists");
		}
		
	}
	public List<User> fetchUserList()
	{
		return userRepository.findAll();
	}
	public User fetchUserById(Integer userId)
	{
		return userRepository.findById(userId).get();
	}
	public void deleteUserById(Integer userId)
	{
		 userRepository.deleteById(userId);
	}
	public User updateUser(Integer userId,User user)
	{
		User docDB = userRepository.findById(userId).get();
		if(Objects.nonNull(user.getUsername())&&
				!"".equalsIgnoreCase(user.getUsername()))
		{
			docDB.setUsername(user.getUsername());
		}
		if(Objects.nonNull(user.getPassword())&&
				!"".equalsIgnoreCase(user.getPassword()))
		{
			docDB.setPassword(user.getPassword());
		}
		if(Objects.nonNull(user.getUserPhNo())&&
				!"".equalsIgnoreCase(user.getUserPhNo()))
		{
			docDB.setUserPhNo(user.getUserPhNo());;
		}
		return userRepository.save(docDB);
	}
	public User fetchByusername(String username)
	{
		return userRepository.findByusername(username);
	}
}