package com.ps.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ps.bo.EmployeeBO;
import com.ps.bo.EmployeeResultBO;

@Repository("/empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMP_DETAILS="(SELECT EMPNO,ENAME,JOB,SAL,DEPTNO,MGR FROM EMP WHERE (EMPNO IS NOT NULL AND EMPNO=?) OR (ENAME IS NOT NULL AND ENAME LIKE ?) OR (JOB IS NOT NULL AND JOB LIKE ?) OR (SAL IS NOT NULL AND SAL>=?))";
	
	@Autowired
	private JdbcTemplate jt;

	@Override
	public List<EmployeeResultBO> searchEmployee(EmployeeBO bo) {
		List<EmployeeResultBO> listRBO=null;
		listRBO=jt.query(GET_EMP_DETAILS, rs->{
			List<EmployeeResultBO> listBO1=new ArrayList<EmployeeResultBO>();
			EmployeeResultBO bo1=null;
			while(rs.next()) {
				bo1=new EmployeeResultBO();
				bo1.setEmpno(rs.getInt(1));
				bo1.setEname(rs.getString(2));
				bo1.setJob(rs.getString(3));
				bo1.setSal(rs.getFloat(4));
				bo1.setDeptno(rs.getInt(5));
				bo1.setMgr(rs.getInt(6));
				//add bo object into listBO
				listBO1.add(bo1);				
			}
			//return listBO1 object
			return listBO1;
		}, bo.getEmpno(),bo.getEname(),bo.getJob(),bo.getSal());
		return listRBO;
	}

}
