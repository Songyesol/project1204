package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import DAO.DAO;

public class StreamExample5 {

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
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getInt("salary"));
				emp.setDepartmentId(rs.getInt("department_id"));
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Stream<Employee> stream = list.stream();
		stream.forEach(s-> s.showEmpInfo());
		
      
		//**부서가 없는 경우의 에러 현상 보기 
		//Optional~의 기능 
		System.out.println("40번 부서 평균>>>");
		
		OptionalDouble avg = list.stream().filter(t->t.getDepartmentId() == 50)
		.mapToDouble(v->v.getSalary())
		.average();
		
		System.out.println("평균: " + avg.orElse(0.0)); //1. .orElse() 값이 없으면 괄호안 값을 출력하겠다. 
		
//		avg.ifPresent(new DoubleConsumer() { //2. .ifPresent<- avg라는 변수에 값이 있는지 확인하는 메서드(=만약 존재한다면....)
//
//			@Override
//			public void accept(double value) {
//				System.out.println("평균: " + avg.getAsDouble());
//			}
//			
//		}); 
		
	
	}
}
