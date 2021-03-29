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
	
	private LocalDateTime regDate;		// �ް���û��
	private LocalDateTime regStartDate;	// ������
	private LocalDateTime regEndDate;	// ������
	private Double regNum;				// �ް��ϼ�
	private String regReason; 			// ��û ����	
	private String confirmEmpCode;		// �������ڵ�		
	private LocalDateTime confirmDate;	// �ް� ���� ��¥
	private String rejectReason;		// �ݷ� ����	
	private String code; 				// �ް����� �ڵ�	
	private String vsCode;				// �ް����� �����ڵ�
}
