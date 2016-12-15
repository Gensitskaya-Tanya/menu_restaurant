import javax.persistence.*;

@Entity
@Table(name = "Menu_in_restaurant")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "NameDish", nullable = false)
	private String nameOfTheDish;
	private double cost;
	private int weight;
	private boolean availabilityOfdiscounts;

	public Menu() {
	}

	public Menu(String nameOfTheDish, double cost, int weight, boolean availabilityOfdiscounts) {
		this.nameOfTheDish = nameOfTheDish;
		this.cost = cost;
		this.weight = weight;
		this.availabilityOfdiscounts = availabilityOfdiscounts;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameOfTheDish() {
		return nameOfTheDish;
	}

	public void setNameOfTheDish(String nameOfTheDish) {
		this.nameOfTheDish = nameOfTheDish;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isAvailabilityOfdiscounts() {
		return availabilityOfdiscounts;
	}

	public void setAvailabilityOfdiscounts(boolean availabilityOfdiscounts) {
		this.availabilityOfdiscounts = availabilityOfdiscounts;
	}


	@Override
	public String toString() {
		return "Menu{" +
				"id=" + id +
				", nameOfTheDish='" + nameOfTheDish + '\'' +
				", cost=" + cost +
				", weight=" + weight +
				", availabilityOfdiscounts=" + availabilityOfdiscounts +
				'}';
	}
}
