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
	
	private LocalDate regStartDate;		// ������
	private LocalDate regEndDate;			// ������
	private Double regNum;				// �ް��ϼ�
	private String regReason; 			// ��û ����	
	private String code; 				// �ް����� �ڵ�	
	private String empCode; 				// �ް����� �ڵ�	
}
