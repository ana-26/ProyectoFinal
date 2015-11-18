package bravo.dao.hibernate;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import bravo.dao.FoodDao;
import bravo.model.Food;

import java.util.List;


@Repository("foodDao")
public class FoodDaoHibernate extends GenericDaoHibernate<Food,Long>implements FoodDao{

	public FoodDaoHibernate() {
		super(Food.class);
	}

	@SuppressWarnings("unchecked")
	public List<Food> findByName(String name) {
		return getSession().createCriteria(Food.class).add(Restrictions.eq("name", name)).list();
	}	

}
