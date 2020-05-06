package com.ps.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ps.bo.PatientBO;

@Repository
public final class PatientDAOImpl implements PatientDAO {
	private static final String PATIENT_REGISTRATION_QUERY="INSERT INTO CORONA_REGISTRATION VALUES(CORONA_PATID_SEQ.NEXTVAL,?,?,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int insert(PatientBO bo) {
		int count=0;
		count=jt.update(PATIENT_REGISTRATION_QUERY, bo.getPatName(),bo.getPatAdd(),bo.getAge(),bo.getGender(),bo.getStage(),bo.getHospital());
				
		return count;
	}

}
