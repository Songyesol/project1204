package stream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
		
      
		//1) salary가 10000이상인 사원 
		System.out.println("salary가 10,000이상인 사원 >>>");
		list.stream()
		.filter((Employee t) ->t.getSalary()>10000)		
		.forEach(s-> s.showEmpInfo());
		
		
		//2.선적부서의 급여합계 및 평균 
		System.out.println("선적부서의 급여 합계 및 평균>>>");
		int sum = list.stream().filter(t->t.getDepartmentId() == 50)
		.mapToInt(v -> v.getSalary())
		.sum();
		System.out.println("합계: " + sum);
		
		double avg = list.stream().filter(t->t.getDepartmentId() == 50)
		.mapToDouble(v->v.getSalary())
		.average().getAsDouble();
		System.out.println("평균: " + avg);
		
		//3. 급여가 5,000~10,000사이의 사원정보 출력
		System.out.println("급여가 5000~10000사이의 사원정보>>>");
		list.stream().filter(new Predicate<Employee>(){

			@Override
			public boolean test(Employee t) {
				return t.getSalary()>=5000 && t.getSalary()<=10000;
			}
			
		}).forEach(s->s.showEmpInfo1());
		
		//4. emp1테이블의 salary 많은 사람 순으로 줄세우기 
//		System.out.println("salary순으로 내림차순>>>");
//		List<Employee> emp = list.stream().sorted().collect(Collectors.toList());
//		for(Employee employee : emp) {
//			employee.showEmpInfo1();
//	}
//		list.stream().sorted()
//		.forEach(s->s.showEmpInfo1());
		
		
		//5. firstName 기준으로 정렬
		list.stream().sorted().forEach(t->t.showEmpInfo());
		}
	}

