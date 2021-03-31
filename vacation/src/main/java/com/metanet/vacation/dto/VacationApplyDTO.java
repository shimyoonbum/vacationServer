package com.metanet.vacation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.metanet.vacation.model.Code;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacationApplyDTO {
	
	private LocalDate regStartDate;		// 시작일
	private LocalDate regEndDate;			// 종료일
	private Double regNum;				// 휴가일수
	private String regReason; 			// 신청 사유	
	private String code; 				// 휴가유형 코드	
	private String empCode; 				// 휴가유형 코드	
}
