package dao;

import domain.MenuRestaurant;


public interface DaoMenu {

	public void create(MenuRestaurant menu);

	public void update(String nameOfTheDish, String newNameOfTheDish);

	public void delete(long id);

	public void getAll();

	public void viewMenuCostFromTo(double minCost, double maxCost);

	public void viewMenuOnlyDiscount();

	public  void viewMenuWhereWeightLessThan1kg();

}
