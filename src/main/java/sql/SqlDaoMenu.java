package sql;

import dao.DaoMenu;
import domain.MenuRestaurant;

import javax.persistence.*;
import java.util.List;


public class SqlDaoMenu implements DaoMenu {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_MENU");
	private EntityManager em = emf.createEntityManager();


	@Override
	public void create(MenuRestaurant menu) {
		em.getTransaction().begin();
		try {
			em.persist(menu);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void update(String nameOfTheDish, String newNameOfTheDish) {
		MenuRestaurant c = null;
		try {
			Query query = em.createQuery("SELECT c FROM MenuRestaurant c WHERE c.nameOfTheDish = :name", MenuRestaurant.class);
			query.setParameter("name", nameOfTheDish);

			c = (MenuRestaurant) query.getSingleResult();
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

	@Override
	public void delete(long id) {
		MenuRestaurant c = em.find(MenuRestaurant.class, id);
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

	@Override
	public void getAll() {
		Query query = em.createQuery("SELECT c FROM MenuRestaurant c", MenuRestaurant.class);
		List<MenuRestaurant> list = (List<MenuRestaurant>) query.getResultList();
		for (MenuRestaurant c : list)
			System.out.println(c);
	}

	@Override
	public void viewMenuCostFromTo(double minCost, double maxCost) {
		Query query = em.createQuery("SELECT c FROM MenuRestaurant c WHERE (c.cost <:maxCost and c.cost >:minCost )", MenuRestaurant.class);
		query.setParameter("maxCost", maxCost);
		query.setParameter("minCost", minCost);
		List<MenuRestaurant> list = (List<MenuRestaurant>) query.getResultList();

		for (MenuRestaurant c : list)
			System.out.println(c);
	}

	@Override
	public  void viewMenuOnlyDiscount() {
		Query query = em.createQuery("SELECT c FROM MenuRestaurant c WHERE c.availabilityOfdiscounts = true", MenuRestaurant.class);
		List<MenuRestaurant> list = (List<MenuRestaurant>) query.getResultList();

		for (MenuRestaurant c : list)
			System.out.println(c);
	}

	@Override
	public  void viewMenuWhereWeightLessThan1kg() {
		Query query = em.createQuery("SELECT c FROM MenuRestaurant c WHERE c.weight < 1000", MenuRestaurant.class);
		List<MenuRestaurant> list = (List<MenuRestaurant>) query.getResultList();
		int weight = 0;
		for (MenuRestaurant c : list) {
			weight += c.getWeight();
			if (weight <= 1000) {
				System.out.println(c);
			}
		}
	}

}
