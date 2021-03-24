package com.legato.empportal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.legato.empportal.entity.Employee;
import com.legato.empportal.entity.Gender;
import com.legato.empportal.entity.Role;
import com.legato.empportal.repository.EmployeeRepository;
import com.legato.empportal.request.EmployeeRequest;
import com.legato.empportal.service.EmployeeService;
import org.springframework.boot.test.mock.mockito.MockBean;

class EmpServiceApplicationTests {
	private EmployeeService  employeeService;
	private EmployeeRepository emprepo;
	
	@BeforeEach
	 private void setup() {

		  emprepo= mock(EmployeeRepository.class);
		employeeService= new EmployeeService(emprepo);

	}

	@Test
	void addEmployeetest() {
		EmployeeRequest empRequest= new EmployeeRequest();
		empRequest.setCreatedAt(new Date());
		empRequest.setEmpGender("MALE");
		empRequest.setEmpRole("ASSOCIATE");
		empRequest.setEmpSalary(1000.0);
		empRequest.setUpdatedAt(new Date());
		empRequest.setEmpName("Akshay");
		empRequest.setEmpId(1l);
		
		Employee employee = new Employee();

		Gender gender = Gender.valueOf(empRequest.getEmpGender());
		employee.setEmpGender(gender);
		employee.setEmpId(empRequest.getEmpId());
		employee.setEmpName(empRequest.getEmpName());
		employee.setEmpSalary(empRequest.getEmpSalary());
		employee.setCreatedAt(empRequest.getCreatedAt());
		employee.setUpdatedAt(empRequest.getUpdatedAt());
		Role role = Role.valueOf(empRequest.getEmpRole());
		employee.setEmpRole(role);
		
		Mockito.when(emprepo.save(any(Employee.class))).thenReturn(employee);
		Employee savedEmployee = employeeService.addEmployee(empRequest);
		Assertions.assertThat(savedEmployee).isEqualTo(employee);
		
		
	}

	
	
}
