package com.sunil.DetailsMicroservice.Controller;


import java.util.List;

import javax.xml.crypto.Data;

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

import com.sunil.DetailsMicroservice.Entity.Details;
import com.sunil.DetailsMicroservice.Entity.User;
import com.sunil.DetailsMicroservice.ServiceImpl.DetailsServiceImpl;



@RestController
@CrossOrigin
public class DetailsController {
	private RestTemplate restTemp;
    @Autowired
    public DetailsController(RestTemplateBuilder builder) {
        this.restTemp = builder.build();
    }
    
	@Autowired
	private DetailsServiceImpl detailsService;
	@PostMapping("/detailsadd") //Create Details
	public Details saveDetails(@RequestBody Details details) throws Exception
	{
		return detailsService.saveDetails(details);
	}
//	@GetMapping("/details")
//	private List<Details> fetchDetailsB
//	
	
	@GetMapping("/details/{userId}")
	private List<Details> fetchDetailsByUserId(@PathVariable String userId)throws Exception
	{
		return detailsService.fetchDetailsByUserId(Integer.parseInt(userId));
	}
//	@DeleteMapping("details/{user_Id}")
//	private void deleteDetailsByuserId(@RequestBody int user_Id)throws Exception
//	{
//		 detailsService.deletedetailsByuserId(user_Id);
//	}
	@GetMapping("/Alldetails")
	public List<Details> fetchAllDetails() {
		return detailsService.getAllDetails();
	}
}