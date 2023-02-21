package com.sunil.DetailsMicroservice.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunil.DetailsMicroservice.Entity.Details;
import com.sunil.DetailsMicroservice.Entity.User;
import com.sunil.DetailsMicroservice.Repository.DetailsRepository;



@Service
public class DetailsServiceImpl {
	@Autowired
	private DetailsRepository DetailsRepo;

	public List<Details> getAllDetails() {
		List<Details> details = new ArrayList<>();
		DetailsRepo.findAll().forEach(details::add);
		return details;
	}

//	public Details fetchDetailsById(int id) {
//		return DetailsRepo.findById(id);
//	}
	public List<Details> fetchDetailsByUserId(Integer userId)
	{
		return DetailsRepo.findByUserId(userId);
	}
	
	public Details saveDetails(Details details) {
		return DetailsRepo.save(details);
	}
//	public void deletedetailsByuserId(int user_Id) {
//		DetailsRepo.deleteByuserId(user_Id);
//	}

//	public void deleteDetailsById(int id) {
//		DetailsRepo.deleteById(id);
//	}

	public Details updateDetails(int id, Details details) {
		Details dDB = DetailsRepo.findById(id);
		if (Objects.nonNull(details.getDate()) && !"".equalsIgnoreCase(details.getDate())) {
			dDB.setDate(details.getDate());
		}
		if (Objects.nonNull(details.getStatus()) && !"".equalsIgnoreCase(details.getStatus())) {
			dDB.setStatus(details.getStatus());
		}

		return DetailsRepo.save(dDB);
	}


//	public List<Details> fetchByUser(int User_id) {
//		return DetailsRepo.findByUser_Id(User_id);
//	}
}