package com.sunil.UserMicroservice.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.UserMicroservice.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByusername(String username);
	public User findByusernameEqualsIgnoreCase(String username);
	public User findByUserPhNo(String userPhNo);
	
}