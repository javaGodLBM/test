package hr.vo;

import java.io.Serializable;
import java.util.List;

public class Department implements Serializable{
		private int 		departmentId;
		private String		departmentName;
		private String		location;
		private List<Employee> employee;
		
		/******************************************
		 * 부모 테이블 : DEPARTMENT, 자식 테이블 : EMPLOYEE
		 * 하나의 부서에 여러 직원들이 포함된다.
		 * 직원들의 정보를 저장할 Instance 변수.
		 ******************************************/
		
		public Department(){
			
		}
		

		public Department(int departmentId, String departmentName, String location) {
			this.departmentId = departmentId;
			this.departmentName = departmentName;
			this.location = location;
		}


		public Department(int departmentId, String departmentName, String location, List<Employee> employee) {
			this.departmentId = departmentId;
			this.departmentName = departmentName;
			this.location = location;
			this.employee = employee;
		}



		public int getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(int departmentId) {
			this.departmentId = departmentId;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public List<Employee> getEmployee() {
			return employee;
		}


		public void setEmployee(List<Employee> employee) {
			this.employee = employee;
		}


		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}


		@Override
		public String toString() {
			return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", location="
					+ location + ", employee=" + employee + "]";
		}


		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + departmentId;
			result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
			result = prime * result + ((employee == null) ? 0 : employee.hashCode());
			result = prime * result + ((location == null) ? 0 : location.hashCode());
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Department other = (Department) obj;
			if (departmentId != other.departmentId)
				return false;
			if (departmentName == null) {
				if (other.departmentName != null)
					return false;
			} else if (!departmentName.equals(other.departmentName))
				return false;
			if (employee == null) {
				if (other.employee != null)
					return false;
			} else if (!employee.equals(other.employee))
				return false;
			if (location == null) {
				if (other.location != null)
					return false;
			} else if (!location.equals(other.location))
				return false;
			return true;
		}


	
}
