package com.sunil.BookMicroservice.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sunil.BookMicroservice.Entity.Details;


@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer> {
	Details findById(int Id);
//	List<Details> findByUser_Id(int User_Id);
	
}