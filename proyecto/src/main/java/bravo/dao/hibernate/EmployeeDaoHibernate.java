package bravo.dao.hibernate;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import bravo.dao.EmployeeDao;
import bravo.model.Employee;

import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoHibernate extends GenericDaoHibernate<Employee,Long>implements EmployeeDao{
	
	public EmployeeDaoHibernate() {
		super(Employee.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> findByFirstName(String firstName) {
		return getSession().createCriteria(Employee.class).add(Restrictions.eq("firstName", firstName)).list();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findByLastName(String lastName) {
		return getSession().createCriteria(Employee.class).add(Restrictions.eq("lastName", lastName)).list();
	}
}
