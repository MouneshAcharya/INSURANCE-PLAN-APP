package com.mouneshit.service;

import java.util.List;

import com.mouneshit.binding.SearchRequest;
import com.mouneshit.binding.SearchResponse;

public interface ReportService {
	
	public List<SearchResponse> search(SearchRequest request);
	
	public List<String> loadPlan();
	
	public List<String> loadPlanStatus();
	
	
}
