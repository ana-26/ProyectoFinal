package bravo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.appfuse.model.BaseObject;

@XmlRootElement
@Entity
@Table(name = "food")
public class Food extends BaseObject {
	private Long foodId;
	private Set<FoodEmployee> foodEmployee;
	private String name;
	private String description;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id", unique = true, nullable = false)
	public Long getFooId() {
		return foodId;
	}
	public void setFooId(Long fooId) {
		this.foodId = fooId;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "food", cascade = CascadeType.ALL)
	public Set<FoodEmployee> getFoodEmployee() {
		return foodEmployee;
	}
	public void setFoodEmployee(Set<FoodEmployee> foodEmployee) {
		this.foodEmployee = foodEmployee;
	}
	
	@Column(name = "name", length = 50)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "description", length = 50)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Food other = (Food) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (foodId == null) {
			if (other.foodId != null)
				return false;
		} else if (!foodId.equals(other.foodId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", name=" + name + ", description=" + description + "]";
	}
}
