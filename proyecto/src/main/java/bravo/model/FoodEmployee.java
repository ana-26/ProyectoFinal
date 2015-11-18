package bravo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "FoodEmployee")
@Entity
@Table(name = "food_employee")
public class FoodEmployee extends BaseObject{
	private Long foodEmployeeId;
	private Food food;
	private Employee employee;
	private String confirm;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_employee_id", unique = true, nullable = false)
	public Long getFoodEmployeeId() {
		return foodEmployeeId;
	}
	public void setFoodEmployeeId(Long foodEmployeeId) {
		this.foodEmployeeId = foodEmployeeId;
	}
	
	@ManyToOne
	@JoinColumn(name = "food_id", nullable = false)
	@JsonIgnore
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)
	@JsonIgnore
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Column(name = "confirm", length = 50)
	public String getConfirm() {
		return confirm;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirm == null) ? 0 : confirm.hashCode());
		result = prime * result + ((foodEmployeeId == null) ? 0 : foodEmployeeId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodEmployee other = (FoodEmployee) obj;
		if (confirm == null) {
			if (other.confirm != null)
				return false;
		} else if (!confirm.equals(other.confirm))
			return false;
		if (foodEmployeeId == null) {
			if (other.foodEmployeeId != null)
				return false;
		} else if (!foodEmployeeId.equals(other.foodEmployeeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FoodEmployee [foodEmployeeId=" + foodEmployeeId + ", confirm=" + confirm + "]";
	}
}
