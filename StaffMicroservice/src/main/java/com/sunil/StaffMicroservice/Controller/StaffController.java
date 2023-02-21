package com.sunil.StaffMicroservice.Controller;


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

import com.sunil.StaffMicroservice.Entity.Staff;
import com.sunil.StaffMicroservice.ServiceImpl.StaffServiceImpl;




@RestController
@CrossOrigin
public class StaffController {
	private RestTemplate restTemp;
    @Autowired
    public StaffController(RestTemplateBuilder builder) {
        this.restTemp = builder.build();
    }
    
	@Autowired
	private StaffServiceImpl staffService;
	@PostMapping("/staffadd") //Create staff Details
	public Staff saveStaff(@RequestBody Staff staff) throws Exception
	{
		return staffService.saveStaff(staff);
	}
	@GetMapping("/Getstaff") // Get staff Details
	public List<Staff> fetchstaffList()
	{
		return staffService.fetchStaffList();
	}
	@GetMapping("/staff/{id}") //Get staff Details by staff Id
	public Staff fetchStaffById(@PathVariable("id") Integer staff_Id)
	{
		return staffService.fetchStaffById(staff_Id);
	}
	@PutMapping("/staff/{id}") //update staff Details by staff id
	public Staff updateStaff(@PathVariable("id") Integer staff_Id,@RequestBody Staff staff)
	{
		return staffService.updateStaff(staff_Id, staff);
	}
	@GetMapping("/staff/{name}") //Get staff details by user Name
	public Staff fetchByusername(@PathVariable("name") String username)
	{
		return staffService.fetchByusername(username);
	}
	@DeleteMapping("/user/{id}") //delete staff details by user id
	public void deleteStaffById(@PathVariable("id") Integer staff_Id)
	{
		staffService.deleteStaffById(staff_Id);
	}
}