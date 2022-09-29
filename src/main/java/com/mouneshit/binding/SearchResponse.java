package com.mouneshit.binding;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {
	
	private Integer caseNum;
	private String planName;
	private String planStatus;
	private Double benefitAmt;
	private LocalDate startDate;
	private LocalDate endDate;
	private String denialReason;
	private String  holderName;
	private String holderSSN;

}
