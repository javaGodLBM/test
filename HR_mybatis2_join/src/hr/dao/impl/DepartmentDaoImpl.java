package hr.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import hr.dao.DepartmentDao;
import hr.vo.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	private static DepartmentDaoImpl instance;

	private DepartmentDaoImpl() {
	}

	public static DepartmentDaoImpl getInstance() {
		if (instance == null) {
			instance = new DepartmentDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Department> selectDepartmentList(SqlSession session) {
		return session.selectList("hr.dao.config.mapper.departmentMapper.selectDepartmentList");
	}

	@Override
	public Department selectDepartmentById(SqlSession session, int departmentId) {
		return session.selectOne("hr.dao.config.mapper.departmentMapper.selectDepartmentById",departmentId);
	}

}
