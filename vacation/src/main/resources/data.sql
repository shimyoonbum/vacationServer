INSERT INTO vacation.tb_authority (authority_name) VALUES ('ROLE_ADMIN'),('ROLE_USER');

INSERT INTO vacation.TB_CODE_GROUP (group_code,group_name) VALUES ('OD','조직구분');
INSERT INTO vacation.TB_CODE_GROUP (group_code,group_name) VALUES ('VK','휴가유형');
INSERT INTO vacation.TB_CODE_GROUP (group_code,group_name) VALUES ('VS','휴가승인상태');

INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VK1','VK','연차','1');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VK2','VK','반차','0.5');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VK3','VK','출산전후휴가','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VK4','VK','배우자출산휴가','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VK5','VK','경조사휴가','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VK6','VK','생리휴가','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VK7','VK','병가','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VS1','VS','대기','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VS2','VS','승인','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('VS3','VS','반려','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('1','OD','최상위','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('2','OD','본부','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('3','OD','그룹','0');
INSERT INTO vacation.TB_CODE (CODE,GROUP_CODE,CODE_NAME,CODE_VALUE) VALUES ('4','OD','팀','0');

INSERT INTO vacation.TB_ORGANIZATION (ORG_CODE,ORG_NAME,code,ORG_UPPER) VALUES ('OR0001','사장','1',NULL);
INSERT INTO vacation.TB_ORGANIZATION (ORG_CODE,ORG_NAME,code,ORG_UPPER) VALUES ('OR0002','용산','2','OR0001');
INSERT INTO vacation.TB_ORGANIZATION (ORG_CODE,ORG_NAME,code,ORG_UPPER) VALUES ('OR0003','SI','3','OR0002');
INSERT INTO vacation.TB_ORGANIZATION (ORG_CODE,ORG_NAME,code,ORG_UPPER) VALUES ('OR0004','SM','3','OR0002');
INSERT INTO vacation.TB_ORGANIZATION (ORG_CODE,ORG_NAME,code,ORG_UPPER) VALUES ('OR0005','SI1','4','OR0003');
INSERT INTO vacation.TB_ORGANIZATION (ORG_CODE,ORG_NAME,code,ORG_UPPER) VALUES ('OR0006','SI2','4','OR0003');
INSERT INTO vacation.TB_ORGANIZATION (ORG_CODE,ORG_NAME,code,ORG_UPPER) VALUES ('OR0007','SM1','4','OR0004');
INSERT INTO vacation.TB_ORGANIZATION (ORG_CODE,ORG_NAME,code,ORG_UPPER) VALUES ('OR0008','SM2','4','OR0005');

INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0001','박정식','사장','OR0001','M','01076451234',TIMESTAMP '1995-01-01 00:00:00.000000',NULL);
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0002','윤태훈','이사','OR0002','M','01075241244',TIMESTAMP '1995-01-01 00:00:00.000000','E0001');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0003','홍인택','부장','OR0003','M','01012341234',TIMESTAMP '1995-01-01 00:00:00.000000','E0002');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0004','이상준','부장','OR0004','M','01085644242',TIMESTAMP '1995-01-01 00:00:00.000000','E0002');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0005','송찬규','차장','OR0005','M','01099460013',TIMESTAMP '2001-09-08 00:00:00.000000','E0003');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0006','김민섭','과장','OR0005','M','01042539764',TIMESTAMP '2005-01-01 00:00:00.000000','E0005');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0007','차경운','사원','OR0005','F','01073668462',TIMESTAMP '2005-01-27 00:00:00.000000','E0005');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0008','유진솔','차장','OR0006','F','01019948424',TIMESTAMP '2004-03-20 00:00:00.000000','E0003');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0009','최우빈','과장','OR0006','M','01055553333',TIMESTAMP '2004-07-01 00:00:00.000000','E0008');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0010','조준형','대리','OR0006','M','01066661038',TIMESTAMP '2004-12-15 00:00:00.000000','E0008');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0011','심윤범','과장','OR0007','M','01064258465',TIMESTAMP '2009-11-11 00:00:00.000000','E0004');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0012','정희라','대리','OR0007','F','01064268465',TIMESTAMP '2010-01-10 00:00:00.000000','E0011');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0013','전여진','사원','OR0007','F','01064743665',TIMESTAMP '2009-01-10 00:00:00.000000','E0011');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0014','박우성','차장','OR0008','M','01054238555',TIMESTAMP '2013-06-08 00:00:00.000000','E0004');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0015','전강산','과장','OR0008','M','01090011427',TIMESTAMP '2013-08-10 00:00:00.000000','E0014');
INSERT INTO vacation.TB_EMPLOYEE (EMP_CODE,EMP_NAME,EMP_RANK,ORG_CODE,GENDER,PHONE,JOIN_DATE,EMP_UPPER) VALUES ('E0016','김지훈','대리','OR0008','M','01010046667',TIMESTAMP '2013-10-22 00:00:00.000000','E0014');

INSERT INTO vacation.tb_account (user_id,activated,password,username,emp_code) VALUES 
('ID0001',1,'$2a$10$.u7Wzv3AVJPB9KqDEuvr7eGr/MA1HSWm2CwKwxgnNd1dPqGN2.adi','pjs1234@gmail.com','E0001')
,('ID0002',1,'$2a$10$EHP0j.Uis.o/wl3Owj/CQe7/2Du9zToVLEuhOK8PnnLE6pEsMzyX6','yth1234@gmail.com','E0002')
,('ID0003',1,'$2a$10$Qddf.M6uPqBMnnEsp7UpP.xixtFo671be2ZSe6uG1d5D1Zd/UZWbW','hit1234@gmail.com','E0003')
,('ID0004',1,'$2a$10$FkorSGP79LXNFv1si68hheMn72X7mmVTZ0vL08YfsesFxMN/9JEmG','lsj1234@gmail.com','E0004')
,('ID0005',1,'$2a$10$NJTNPPUPSH/dbU7szKBmvumRtQPIYJVjZcrBiUbWKefd012b0cI3C','scg1234@gmail.com','E0005')
,('ID0006',1,'$2a$10$33oSs2ygyguBAP0mm/B0He6OClIXFMjCzET4Axik6VHLVazERd0oq','kms1234@gmail.com','E0006')
,('ID0007',1,'$2a$10$780myjCukUyUDChuCet13.OG4sIv2QudI4O/8p7YcmHMM704NVPhK','ckw1234@gmail.com','E0007')
,('ID0008',1,'$2a$10$GoBC6tzAeIcwNRYDZdmbtOs8CvwkQY7XueH23mHTRJoV7NywCo1Ca','yjs1234@gmail.com','E0008')
,('ID0009',1,'$2a$10$LI6GWFb.7ZB8WHoiiGV5mO7YP6mYNie6Ud9uI6Z0Cw8xjpbWdXhwa','cwb1234@gmail.com','E0009')
,('ID0010',1,'$2a$10$KFZcZ2y8jbgmgdPHc/y/c.nNthRSgElv6GYCTVXOndiotinlQf6F6','jjh1234@gmail.com','E0010');
INSERT INTO vacation.tb_account (user_id,activated,password,username,emp_code) VALUES 
('ID0011',1,'$2a$10$Ya1yKuEPXDFc4aCvBf6uiOdBsCjVHyeXuyGJ2FIveZRLJ./CdkXt.','syb1234@gmail.com','E0011')
,('ID0012',1,'$2a$10$0unYqyOnqR/4l/9aN/M/kO3//9VcNwzhE8sIpc6NGrFTedKZpNrs.','jhr1234@gmail.com','E0012')
,('ID0013',1,'$2a$10$ZiTcdNGKWJf8Oc4P49rYYOXrmrQlpAkRNgZpMhDPUFAou0ZBSkAEe','jyj1234@gmail.com','E0013')
,('ID0014',1,'$2a$10$pJ9VlJFfwYSmQQ42afI5AePOByLekfPr0XzBb0Lk2Z.N2BG05qzVa','pws1234@gmail.com','E0014')
,('ID0015',1,'$2a$10$.G89USsF3QReIN2rBqbQ7.neBPru9VFg2V57449Zo1Qo6wfZCXS4u','jgs1234@gmail.com','E0015')
,('ID0016',1,'$2a$10$jZvVYj6yhatCorGgkOZLSu/QUZHH9ww4hJCQxMt7tBuwEX.vvN8ri','kjh1234@gmail.com','E0016');

INSERT INTO vacation.tb_account_authority (user_id,authority_name) VALUES 
('ID0001','ROLE_USER')
,('ID0002','ROLE_USER')
,('ID0003','ROLE_USER')
,('ID0004','ROLE_USER')
,('ID0005','ROLE_USER')
,('ID0006','ROLE_USER')
,('ID0007','ROLE_USER')
,('ID0008','ROLE_USER')
,('ID0009','ROLE_USER')
,('ID0010','ROLE_USER');
INSERT INTO vacation.tb_account_authority (user_id,authority_name) VALUES 
('ID0011','ROLE_USER')
,('ID0012','ROLE_USER')
,('ID0013','ROLE_USER')
,('ID0014','ROLE_USER')
,('ID0015','ROLE_USER')
,('ID0016','ROLE_USER');

INSERT INTO vacation.tb_account_authority (user_id,authority_name) VALUES 
('ID0001','ROLE_ADMIN')
,('ID0002','ROLE_ADMIN')
,('ID0003','ROLE_ADMIN')
,('ID0004','ROLE_ADMIN')
,('ID0005','ROLE_ADMIN')
,('ID0008','ROLE_ADMIN')
,('ID0011','ROLE_ADMIN')
,('ID0014','ROLE_ADMIN');

INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0001','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0002','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0003','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0004','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0005','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0006','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0007','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0008','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0009','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0010','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0011','2019',15,1,14);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0012','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0013','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0014','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0015','2019',15,0,15);
INSERT INTO vacation.tb_vacation_management (emp_code,`year`,ACQ_DAYS_NUM,USE_DAYS_NUM,RES_DAYS_NUM) VALUES ('E0016','2019',15,0,15);

INSERT INTO vacation.TB_VACATION_APPLY(emp_code,confirm_emp_code,reg_date,reg_start_date,reg_end_date,reg_num,code,reg_reason,confirm_date,vs_code,reject_reason) VALUES ('E0011','E0004',TIMESTAMP '2020-12-20 16:29:09',TIMESTAMP '2020-12-08 00:00:00',TIMESTAMP '2020-12-08 00:00:00',1,'VK1','cv',TIMESTAMP '2020-12-20 16:34:09','VS1',NULL);
INSERT INTO vacation.TB_VACATION_APPLY(emp_code,confirm_emp_code,reg_date,reg_start_date,reg_end_date,reg_num,code,reg_reason,confirm_date,vs_code,reject_reason) VALUES ('E0013','E0004',TIMESTAMP '2020-12-20 16:29:09',TIMESTAMP '2020-12-08 00:00:00',TIMESTAMP '2020-12-08 00:00:00',1,'VK1','cv',TIMESTAMP '2020-12-20 16:34:09','VS2',NULL);
INSERT INTO vacation.TB_VACATION_APPLY(emp_code,confirm_emp_code,reg_date,reg_start_date,reg_end_date,reg_num,code,reg_reason,confirm_date,vs_code,reject_reason) VALUES ('E0013','E0004',TIMESTAMP '2020-12-20 16:29:09',TIMESTAMP '2020-12-08 00:00:00',TIMESTAMP '2020-12-08 00:00:00',1,'VK1','cv',TIMESTAMP '2020-12-20 16:34:09','VS3','응 못가');
INSERT INTO vacation.TB_VACATION_APPLY (emp_code,confirm_emp_code,reg_date,reg_start_date,reg_end_date,reg_num,code,reg_reason,confirm_date,vs_code,reject_reason) VALUES ('E0013','E0008',TIMESTAMP '2020-11-10 11:25:57',TIMESTAMP '2020-01-15 00:00:00',TIMESTAMP '2020-01-20 00:00:00',NULL,'VK1','동생 결혼식 다녀오겠습니다.',NULL,'VS3','응 못가');
INSERT INTO vacation.TB_VACATION_APPLY (emp_code,confirm_emp_code,reg_date,reg_start_date,reg_end_date,reg_num,code,reg_reason,confirm_date,vs_code,reject_reason) VALUES ('E0013','E0011',TIMESTAMP '2020-11-10 13:30:06',TIMESTAMP '2020-11-11 00:00:00',TIMESTAMP '2020-11-13 00:00:00',3,'VK1','ㅁㄴㅇㄴㅇㄻㄹㅇㄴ',TIMESTAMP '2020-11-10 13:32:14','VS2',NULL);

commit;
