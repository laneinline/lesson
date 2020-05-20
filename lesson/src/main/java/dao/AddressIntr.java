package dao;

import java.sql.SQLException;
import java.util.List;

import entity.Address;

public interface AddressIntr {
	//c
	void create(Address address) throws SQLException;
	//r
	List<Address> getAll() throws SQLException;
	Address getById(long id) throws SQLException;
	//u
	void update(Address address) throws SQLException;
	//d
	void delete(Address address) throws SQLException;
}
