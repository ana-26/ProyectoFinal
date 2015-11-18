package bravo.dao;

import org.appfuse.dao.GenericDao;

import bravo.model.Food;
import java.util.List;

public interface FoodDao extends GenericDao<Food,Long>{
	public List<Food> findByName(String name);
}
