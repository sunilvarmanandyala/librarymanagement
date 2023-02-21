package com.sunil.StaffMicroservice.ServiceImpl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.StaffMicroservice.Entity.Staff;
import com.sunil.StaffMicroservice.Repository.StaffRepository;


@Service
public class StaffServiceImpl {
	@Autowired
	public StaffRepository staffRepository;
	public Staff saveStaff(Staff staff) throws Exception
	{
		String userPhNo = staff.getStaffPhNo();
		Staff existingStaff = staffRepository.findByStaffPhNo(userPhNo);
		
		if (existingStaff == null) {
			return staffRepository.save(staff);
		}
		else {
			throw new Exception("staff data already exists");
		}
		
	}
	public List<Staff> fetchStaffList()
	{
		return staffRepository.findAll();
	}
	public Staff fetchStaffById(Integer staffId)
	{
		return staffRepository.findById(staffId).get();
	}
	public void deleteStaffById(Integer staffId)
	{
		 staffRepository.deleteById(staffId);
		
	}
	public Staff updateStaff(Integer staffId,Staff staff)
	{
		Staff docDB = staffRepository.findById(staffId).get();
		if(Objects.nonNull(staff.getUsername())&&
				!"".equalsIgnoreCase(staff.getUsername()))
		{
			docDB.setUsername(staff.getUsername());
		}
		if(Objects.nonNull(staff.getPassword())&&
				!"".equalsIgnoreCase(staff.getPassword()))
		{
			docDB.setPassword(staff.getPassword());
		}
		if(Objects.nonNull(staff.getStaffPhNo())&&
				!"".equalsIgnoreCase(staff.getStaffPhNo()))
		{
			docDB.setStaffPhNo(staff.getStaffPhNo());;
		}
		return staffRepository.save(docDB);
	}
	public Staff fetchByusername(String username)
	{
		return staffRepository.findByusername(username);
	}
}