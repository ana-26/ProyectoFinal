package bravo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.appfuse.dao.BaseDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import bravo.model.Food;

public class FoodDaoTest  extends BaseDaoTestCase{
	@Autowired
	private FoodDao foodDao;
	
	 @Test
	    public void testFindFoodByName() throws Exception {
	        List<Food> food = foodDao.findByName("cereal");
	        assertTrue(food.size() > 0);
	    }
	 
	 @Test(expected=DataAccessException.class)
	    public void testAddAndRemoveFood() throws Exception {
	        Food food = new Food();
	        food.setName("empanada");
	        food.setDescription("contenido frijoles");

	        food = foodDao.save(food);
	        flush();

	        food = foodDao.get(food.getFooId());

	        assertEquals("empanada", food.getName());
	        assertNotNull(food.getFooId());

	        log.debug("removing food...");

	        foodDao.remove(food.getFooId());
	        flush();

	        // should throw DataAccessException
	        foodDao.get(food.getFooId());
	    }

}
