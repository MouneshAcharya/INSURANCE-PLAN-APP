package com.mouneshit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ELIGIBILITY_DTLS")
public class EligibilityDetails {
	@Id
	@GeneratedValue
	@Column(name = "ELIG_ID")
	private Integer eligId;
	@Column(name = "PLAN_ID")
	private Integer planId;
	@Column(name = "CASE_NUM")
	private Integer caseNum;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@Column(name = "HOLDER_NAME")
	private String holderName;
	@Column(name = "HOLDER_SSN")
	private String holderSSN;
	@Column(name = "BENEFIT_AMT")
	private Double benefitAmt;
	@Column(name = "START_DATE")
	private LocalDate startDate;
	@Column(name = "END_DATE")
	private LocalDate endDate;
	@Column(name = "DENIAL_REASN")
	private String denialReason;
//	@CreationTimestamp
//	@Column(name = "CREATED_DATE", updatable = false)
//	private LocalDate createdDate;
//	@UpdateTimestamp()
//	@Column(name = "UPDATED_DATE", insertable = false)
//	private LocalDate updatedDate;

}
