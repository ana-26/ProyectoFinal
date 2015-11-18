package bravo.dao;

import org.appfuse.dao.GenericDao;

import bravo.model.Employee;
import java.util.List;

public interface EmployeeDao extends GenericDao<Employee,Long>{
	public List<Employee> findByFirstName(String firstName);

	public List<Employee> findByLastName(String lastName);

	

}
