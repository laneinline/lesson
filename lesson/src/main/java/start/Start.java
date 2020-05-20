package start;

import java.sql.SQLException;

import entity.Address;
import entity.Employee;
import dao.AddressDao;
import dao.EmployeeDao;
//import org.mockito.Mockito.*;




public class Start {

	public static void main(String[] args) {
		
		//Address address2 = Mocki
		
		AddressDao addressDao = new AddressDao();
		EmployeeDao employeeDao = new EmployeeDao();
		
		Address address = new Address();
		Employee employee = new Employee();
		
		
		address.createDummy();
		System.out.println(address.toString());
		System.out.println(String.valueOf(address.hashCode()));
		
		employee.createDummy();
		System.out.println(employee.toString());
		System.out.println(String.valueOf(employee.hashCode()));
		
		try {
			Address address2 =new AddressDao().getById(1l);
			System.out.print(address2.toString());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		try {
			addressDao.create(address);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			employeeDao.create(employee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	


}
