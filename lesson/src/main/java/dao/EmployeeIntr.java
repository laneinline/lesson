package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Employee;

public interface EmployeeIntr {
	//c
	void create(Employee employee) throws SQLException;
	//r
	List<Employee>	getAll();
	Employee getById(long id);
	//u
	void update(Employee employee);
	//d
	void delete(Employee employee);
}
