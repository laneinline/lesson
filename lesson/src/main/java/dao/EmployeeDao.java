package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import entity.Employee;


public class EmployeeDao extends DBConnection implements EmployeeIntr {
	Connection connection = getConnection();
	
	@Override
	public void create(Employee employee) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO employee (id,first_name,last_name, birthday, address_id) values(?,?,?,?,?);";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, employee.getId());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setDate(4, employee.getBirthday());
			preparedStatement.setLong(5, employee.getAddressId());
			preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
