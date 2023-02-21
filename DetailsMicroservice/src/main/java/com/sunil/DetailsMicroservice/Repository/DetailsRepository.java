package com.sunil.DetailsMicroservice.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.sunil.DetailsMicroservice.Entity.Details;
import com.sunil.DetailsMicroservice.Entity.User;

@Repository
public interface DetailsRepository extends JpaRepository<Details, Integer> {
	Details findById(int Id);
	List<Details> findByUserId(Integer userId);

//	void deleteByUser(User user);

}