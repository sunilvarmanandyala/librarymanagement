package com.sunil.BookMicroservice.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.BookMicroservice.Entity.Staff;


@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
	public Staff findByusername(String username);
	public Staff findByusernameEqualsIgnoreCase(String username);
	public Staff findByStaffPhNo(String staffPhNo);
	
}