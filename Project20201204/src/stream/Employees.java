package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAO;

public class Employees {

	/*hr: emp1
	 * 50: 선적부서
	 * salary 10000이상인 사원 출력(사원번호, 이름, 메일 ,급여)
	 * 선적부서의 급여합계&평균
	 * 급여(5000~10000)(사원번호, 이름,메일 급여)
	 */

	public static void main(String[] args) {
		Connection conn =DAO.getConnection();
		PreparedStatement psmt;
		String sql;
		ResultSet rs;
		
		sql = "select * from emp1";
		List<Employee> list = new ArrayList<Employee>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDepartment_id(rs.getInt("department_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		list.stream();
		
       
		//1) salary가 10000이상인 사원 
	}
	
}
