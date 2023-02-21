package com.sunil.StaffMicroservice.Service;


import java.util.List;

import com.sunil.StaffMicroservice.Entity.Staff;
public interface StaffService {
	public static Staff saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<Staff> fetchStaffList() {
		// TODO Auto-generated method stub
		return null;
	}
	public Staff fetchStaffById(Integer userId);
	public void deleteStaffById(Integer userId);
	public Staff updateStaff(Integer userId,Staff staff);
	public Staff fetchByusername(String username);
	List<Staff> findByusername(String username);
}