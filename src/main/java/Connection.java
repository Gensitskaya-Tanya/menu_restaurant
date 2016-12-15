import javax.persistence.*;
import java.util.List;


public class Connection {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_MENU");
	public static EntityManager em = emf.createEntityManager();

	public static void addMenu(String nameOfTheDish, double cost, int weight, boolean availabilityOfdiscounts) {
		Menu c = new Menu(nameOfTheDish, cost, weight, availabilityOfdiscounts);
		em.getTransaction().begin();
		try {
			em.persist(c);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	public static void deleteMenu(long id) {
		Menu c = em.find(Menu.class, id);
		if (c == null) {
			System.out.println("Menu not found!");
			return;
		}
		em.getTransaction().begin();
		try {
			em.remove(c);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}

	}

	public static void changeMenu(String nameOfTheDish, String newNameOfTheDish) {
		Menu c = null;
		try {
			Query query = em.createQuery("SELECT c FROM Menu c WHERE c.nameOfTheDish = :name", Menu.class);
			query.setParameter("name", nameOfTheDish);

			c = (Menu) query.getSingleResult();
		} catch (NoResultException ex) {
			System.out.println("Menu not found!");
			return;
		} catch (NonUniqueResultException ex) {
			System.out.println("Non unique result!");
			return;
		}
		em.getTransaction().begin();
		try {
			c.setNameOfTheDish(newNameOfTheDish);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	public static void viewMenu() {
		Query query = em.createQuery("SELECT c FROM Menu c", Menu.class);
		List<Menu> list = (List<Menu>) query.getResultList();

		for (Menu c : list)
			System.out.println(c);
	}

	public static void viewMenuCostFromTo(double minCost, double maxCost) {
		Query query = em.createQuery("SELECT c FROM Menu c WHERE (c.cost <:maxCost and c.cost >:minCost )", Menu.class);
		query.setParameter("maxCost", maxCost);
		query.setParameter("minCost", minCost);
		List<Menu> list = (List<Menu>) query.getResultList();

		for (Menu c : list)
			System.out.println(c);
	}

	public static void viewMenuOnlyDiscount() {
		Query query = em.createQuery("SELECT c FROM Menu c WHERE c.availabilityOfdiscounts = true", Menu.class);
		List<Menu> list = (List<Menu>) query.getResultList();

		for (Menu c : list)
			System.out.println(c);
	}

	public static void viewMenuWhereWeightLessThan1kg() {
		Query query = em.createQuery("SELECT c FROM Menu c WHERE c.weight < 1000", Menu.class);
		List<Menu> list = (List<Menu>) query.getResultList();
		int weight = 0;
		for (Menu c : list) {
			weight += c.getWeight();
			if (weight <= 1000) {
				System.out.println(c);
			}
		}
	}
}
