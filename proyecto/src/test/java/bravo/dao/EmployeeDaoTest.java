package bravo.dao;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import bravo.model.Employee;

public class EmployeeDaoTest extends BaseDaoTestCase {
	@Autowired
	private EmployeeDao employeeDao;
	
	 @Test
	    public void testFindEmployeeByFirstName() throws Exception {
	        List<Employee> employee = employeeDao.findByFirstName("Roberto");
	        assertTrue(employee.size() > 0);
	    }
	    
	    @Test
	    public void testFindEmployeeByLastName() throws Exception {
	        List<Employee> employee = employeeDao.findByLastName("Perez");
	        assertTrue(employee.size() > 0);
	    }
	    
	    @Test(expected=DataAccessException.class)
	    public void testAddAndRemovePerson() throws Exception {
	    	Employee employee = new Employee();
	    	employee.setFirstName("David");
	    	employee.setLastName("Arias");

	    	employee = employeeDao.save(employee);
	        flush();

	        employee = employeeDao.get(employee.getEmployeeId());

	        assertEquals("David", employee.getFirstName());
	        assertNotNull(employee.getEmployeeId());

	        log.debug("removing employee...");

	        employeeDao.remove(employee.getEmployeeId());
	        flush();

	        // should throw DataAccessException
	        employeeDao.get(employee.getEmployeeId());
	    }

}
