package com.ps.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.ps.bo.EmployeeBO;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_ALL_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP";
	private static final String GET_ONE_EMPS="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE EMPNO=?";
	private static final String UPDATE_EMP_BY_NO="UPDATE EMP SET ENAME=?,JOB=?,SAL=?,DEPTNO=? WHERE EMPNO=?";
	private static final String DELETE_EMP_BY_NO="DELETE EMP WHERE EMPNO=?";
	private static final String INSERT_EMP_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO) VALUES(EMP_ID.NEXTVAL,?,?,?,?)";
	
	@Autowired
	private JdbcTemplate jt;
		
	@Override
	public List<EmployeeBO> getAllEmps() {
		List<EmployeeBO> listBO=null;
		listBO=jt.query(GET_ALL_EMPS,new EmployeeExtractor());
		return listBO;
	}
	
	private class EmployeeExtractor implements ResultSetExtractor<List<EmployeeBO>>{
		
		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO=null;
			EmployeeBO bo=null;
			//copy ResultSet object records BO class objects and add them to list collection
			listBO=new ArrayList();
			while(rs.next()) {
				//copy each record to BO class object
				bo=new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSal(rs.getFloat(4));
				bo.setDeptNo(rs.getInt(5));
				//add each BO class object to List Collection
				listBO.add(bo);
			}//while
			return listBO;
		}//extractData(-)
		
	}//inner class

	@Override
	public EmployeeBO getEmpByNo(int empno) {
		EmployeeBO bo=null;
		bo=jt.queryForObject(GET_ONE_EMPS, (rs,index)->{
			EmployeeBO bo1=null;
			bo1=new EmployeeBO();
			bo1.setEmpNo(rs.getInt(1));
			bo1.setEName(rs.getString(2));
			bo1.setJob(rs.getString(3));
			bo1.setSal(rs.getFloat(4));
			bo1.setDeptNo(rs.getInt(5));
			//return bo
			return bo1;
		}, empno);
		return bo;
	}

	@Override
	public int updateEmpByNo(EmployeeBO bo) {
		int count=0;
		count=jt.update(UPDATE_EMP_BY_NO, bo.getEName(),bo.getJob(),bo.getSal(),bo.getDeptNo(),bo.getEmpNo());		
		return count;
	}

	@Override
	public int deleteEmpByNo(int empno) {
		int count=0;
		count=jt.update(DELETE_EMP_BY_NO, empno);
		return count;
	}

	@Override
	public int insertEmp(EmployeeBO bo) {
		int count=0;
		count=jt.update(INSERT_EMP_QUERY, bo.getEName(),bo.getJob(),bo.getSal(),bo.getDeptNo());
		return count;
	}

}//outer class
