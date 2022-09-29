package com.mouneshit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mouneshit.entity.EligibilityDetails;

public interface EligibilityDtlsRepository extends JpaRepository<EligibilityDetails, Integer>{
	
	@Query("select distinct(planName) from EligibilityDetails")
	public List<String> getPlans();
	
	@Query("select distinct(planStatus) from EligibilityDetails")
	public List<String> getPlanStatus();
	
}
