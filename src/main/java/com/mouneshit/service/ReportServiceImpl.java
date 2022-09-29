package com.mouneshit.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.mouneshit.binding.SearchRequest;
import com.mouneshit.binding.SearchResponse;
import com.mouneshit.entity.EligibilityDetails;
import com.mouneshit.repository.EligibilityDtlsRepository;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private EligibilityDtlsRepository repo;

	@Override
	public List<SearchResponse> search(SearchRequest request) {
		List<SearchResponse> responses = new ArrayList<SearchResponse>();
		List<EligibilityDetails> eligibilityDet = null;
		if(isSearchReEmpty(request)) {
			eligibilityDet = repo.findAll();
		} else {
			String planName = request.getPlanName();
			String planStatus = request.getPlanStatus();
			LocalDate startDate = request.getStartDate();
			LocalDate endDate = request.getEndDate();
			EligibilityDetails entity = new EligibilityDetails();
			if(planName != null && !planName.equals("")) {
				entity.setPlanName(planName);
			}
			if(planStatus != null && planStatus.equals("")) {
				entity.setPlanName(planName);
			}
			if(startDate != null && endDate != null) {
				entity.setStartDate(startDate);
				entity.setEndDate(endDate);
			}
			Example<EligibilityDetails> of = Example.of(entity);
			eligibilityDet = repo.findAll(of);
		}
		SearchResponse response = new SearchResponse();
		for(EligibilityDetails detail:eligibilityDet) {
			BeanUtils.copyProperties(detail, response);
			responses.add(response);
		}
		return responses;
	}

	@Override
	public List<String> loadPlan() {
		return repo.getPlans();
	}

	@Override
	public List<String> loadPlanStatus() {
		return repo.getPlanStatus();
	}
	
	private boolean isSearchReEmpty(SearchRequest req) {
		if(req.getPlanName()!=null && !req.getPlanName().equals("")) {
			return false;
		}
		if(req.getPlanStatus()!=null && !req.getPlanStatus().equals("")) {
			return false;
		}
		if(req.getStartDate()!=null && !req.getStartDate().equals("")) {
			return false;
		}
		if(req.getEndDate()!=null && !req.getEndDate().equals("")) {
			return false;
		}
		return true;
	}

}
