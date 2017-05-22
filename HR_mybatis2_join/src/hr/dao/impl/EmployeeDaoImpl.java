package hr.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import hr.dao.EmployeeDao;
import hr.vo.Employee;

public class EmployeeDaoImpl implements EmployeeDao{
	private static EmployeeDaoImpl instance;
	private EmployeeDaoImpl(){
		
	}
	public static EmployeeDaoImpl getInstance(){
		if(instance==null){
			instance = new EmployeeDaoImpl();
		}
		return instance;
	}

	@Override
	public Employee selectEmployeeById(SqlSession session, int employeeId) {
		// TODO Auto-generated method stub
		return session.selectOne("hr.dao.config.mapper.employeeMapper.selectEmployeeById",employeeId);
	}
	@Override
	public List<Employee> selectEmployeeList(SqlSession session) {
		// TODO Auto-generated method stub
		return session.selectList("hr.dao.config.mapper.employeeMapper.selectEmployeeList");
	}
}
