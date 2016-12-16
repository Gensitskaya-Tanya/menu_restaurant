

import dao.DaoMenu;
import domain.MenuRestaurant;
import sql.SqlDaoMenu;

public class Main {
	public static void main(String[] args) {
		MenuRestaurant menu1 = new MenuRestaurant("apple", 25, 1200, true);
		MenuRestaurant menu2 = new MenuRestaurant("crab", 10, 100, true);
		MenuRestaurant menu3 = new MenuRestaurant("fish", 15, 400, false);
		MenuRestaurant menu4 = new MenuRestaurant("fresh", 5, 300, false);
		MenuRestaurant menu5 = new MenuRestaurant("apple", 25, 1200, true);
		MenuRestaurant menu6 = new MenuRestaurant("soup", 10, 100, true);
		MenuRestaurant menu7 = new MenuRestaurant("bread", 15, 100, false);

		DaoMenu daoMenu = new SqlDaoMenu();

//		daoMenu.create(menu1);
//		daoMenu.create(menu2);
//		daoMenu.create(menu3);
//		daoMenu.create(menu4);
//		daoMenu.create(menu5);
//		daoMenu.create(menu6);
//		daoMenu.create(menu7);


//		daoMenu.delete(2);
//		daoMenu.update("crab", "salt");
//		daoMenu.getAll();

//		daoMenu.viewMenuCostFromTo(5, 20);
//		daoMenu.viewMenuOnlyDiscount();
		daoMenu.viewMenuWhereWeightLessThan1kg();

		SqlDaoMenu.em.close();
		SqlDaoMenu.emf.close();
	}

}
