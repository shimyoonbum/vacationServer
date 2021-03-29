package com.metanet.vacation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.metanet.vacation.model.Code;

import lombok.*;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacationApplyDTO {
	
	private LocalDateTime regDate;		// 휴가신청일
	private LocalDateTime regStartDate;	// 시작일
	private LocalDateTime regEndDate;	// 종료일
	private Double regNum;				// 휴가일수
	private String regReason; 			// 신청 사유	
	private String confirmEmpCode;		// 승인자코드		
	private LocalDateTime confirmDate;	// 휴가 승인 날짜
	private String rejectReason;		// 반려 사유	
	private String code; 				// 휴가유형 코드	
	private String vsCode;				// 휴가승인 상태코드
}
