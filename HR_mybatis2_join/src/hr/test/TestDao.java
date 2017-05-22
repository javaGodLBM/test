package hr.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import hr.dao.DepartmentDao;
import hr.dao.EmployeeDao;
import hr.dao.impl.DepartmentDaoImpl;
import hr.dao.impl.EmployeeDaoImpl;
import hr.util.SqlSessionFactoryManager;
import hr.vo.Department;
import hr.vo.Employee;

public class TestDao {
	
	public void testEmployeeDao() throws IOException{
		//EmployeeDao 객체 생성
		EmployeeDao dao = EmployeeDaoImpl.getInstance();
		//SqlSession session = null;
		SqlSession session = null;
		try {
			
			session = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			
			List<Employee> list = dao.selectEmployeeList(session);
			System.out.println("전체조회----------");
			for(Employee e : list){
				System.out.println(e);
			}
			
			int empId = 100;
			System.out.println(empId + "로 조회");
			Employee emp = dao.selectEmployeeById(session, empId);
			System.out.println(emp);
			
			
			
		} finally {
			session.close();
			// TODO: handle finally clause
		}
	}
	
	public void testDepartmentDao()throws IOException{
		DepartmentDao dao = DepartmentDaoImpl.getInstance();
		SqlSession session = null;
		List<Department> list = null;
		try {
			session = SqlSessionFactoryManager.getInstance().getSqlSessionFactory().openSession();
			
			list = dao.selectDepartmentList(session);
			for(Department d : list){
				System.out.println(d);
			}
			
			int dId = 100;
			System.out.println("부서 ID로조회");
			Department d = dao.selectDepartmentById(session, dId);
			System.out.println("-------"+d);
			if(d ==null){
				System.out.println(dId+"번 부서는 없습니다");
			}else{
				System.out.printf("부서 ID : %d, 부서명 : %s, 지역 : %s%n",
											d.getDepartmentId(),
											d.getDepartmentName(),
											d.getLocation());
				System.out.println("소속직원들");
				for(Employee e : d.getEmployee()){
					System.out.println(e);
				}
			}
		} finally {
			session.close();
			// : handle finally clause
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		TestDao test = new TestDao();
//		test.testEmployeeDao();
		
		test.testDepartmentDao();
	}
}
