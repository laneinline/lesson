package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Address;

public class AddressDao extends DBConnection implements AddressIntr {
	
	Connection connection = getConnection();

	@Override
	public void create(Address address) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO address (id, country, city, street, post_code) VALUES (?,?,?,?,?)";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, address.getId());
			preparedStatement.setString(2, address.getCountry());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getStreet());
			preparedStatement.setString(5, address.getPostCode());
			preparedStatement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement !=null) {
				preparedStatement.close();
			}
			if(connection !=null) {
				connection.close();
			}	
		}
	}

	@Override
	public List<Address> getAll() throws SQLException {
		Statement statement =null;
		//String sql = "SELECT id,country,city,street,post_code FROM address";
		List<Address> addressList = new ArrayList<Address>();
		
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.getResultSet();
			
			while(resultSet.next()) {
				Address address = new Address();
				address.setId(resultSet.getLong("id"));
				address.setCountry(resultSet.getString("country"));
				address.setCity(resultSet.getString("city"));
				address.setStreet(resultSet.getString("street"));
				address.setPostCode(resultSet.getString("post_code"));
			
				addressList.add(address);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement!= null ) {
				statement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
		return addressList;
	}

	@Override
	public Address getById(long id) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql ="SELECT id, country, city, street, post_code FROM address WHERE id = ?";
		Address address = new Address();
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			address.setId(resultSet.getLong("id"));
			address.setCountry(resultSet.getString("country"));
			address.setCity(resultSet.getString("city"));
			address.setStreet(resultSet.getString("street"));
			address.setPostCode(resultSet.getString("post_code"));
			
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null ) {
				connection.close();
			}
		}
		return address;
	}

	@Override
	public void update(Address address) throws SQLException {
		PreparedStatement preparedStatement =null;
		String sql = "UPDATE address SET country = ?, city = ?, street = ?, post_code = ? WHERE id = ?";
		
		try {
			preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, address.getCountry());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(3, address.getStreet());
			preparedStatement.setString(4, address.getPostCode());
			preparedStatement.setLong(5, address.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public void delete(Address address) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql ="DELETE FROM address WHERE ID =?";
		
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, address.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
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

}
