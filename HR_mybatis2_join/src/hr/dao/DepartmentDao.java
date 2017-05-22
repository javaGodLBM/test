package hr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import hr.vo.Department;
/**
 * 
 * DEPARTMENT 테이블과 연동되는 Dao Interface
 * 
 * 
 */
public interface DepartmentDao {
	/**
	 * 모든 부서 정보를 조회하는 select 메소드.
	 * 부서_ID, 부서_명, 위치를 조회한다.
	 * @param session
	 * @param departmentId
	 * @return
	 */
	List<Department> selectDepartmentList(SqlSession session);
	/**
	 * 매개변수로 받은 부서_ id의 부서정보를 조회하는 메소드
	 * 부서와 그 부서에 소속된 직원 정보를 조회한다. 
	 * (부모 : 부서, 자식 : 직원, 조회기준-부서,->1:N)
	 * 												
	 * @param session
	 * @param departmentId 조회할 부서_ID
	 * @return
	 */
	Department selectDepartmentById(SqlSession session, int departmentId);

}
