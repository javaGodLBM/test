package hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import hr.vo.Employee;
/**
 *EMPLOYEE 테이블 관련 SQL 처리 Dao 인터페이스
 * @author 이병문 
 *
 */

public interface EmployeeDao {
	
	
	/**
	 *직원_ID로 한명의 직원들 조회하는 메소드
	 *직원의 전체 정보와 그 직원이 소속된 부서정보 조회(DEPARTMENT - JOIN)
	 * @param employeeId
	 * @return 조회한 직원 정보
	 */
	Employee selectEmployeeById(SqlSession session,int employeeId);
	
	
	/**
	 * 전체 직원 정보를 조회하는 메소드
	 * 조회 직원 정보는 소속부서정보를 제외한 지원 정보만 조회.(DEPARTMENT - JOIN안함.)
	 * @return
	 */
	List<Employee> selectEmployeeList(SqlSession session);
	
}






















