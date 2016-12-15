

public class Main {
	public static void main(String[] args) {
		Connection.addMenu("apple", 25, 1200, true);
		Connection.addMenu("juc", 5, 300, false);
		Connection.addMenu("crab", 10, 100, true);
		Connection.addMenu("fish", 15, 400, false);
		Connection.addMenu("fresh", 5, 300, false);
		Connection.addMenu("soup", 10, 100, true);
		Connection.addMenu("bread", 15, 100, false);

//		Connection.deleteMenu(2);
//		Connection.changeMenu("crab", "salt");
//		Connection.viewMenu();

//		Connection.viewMenuCostFromTo(5, 20);
//		Connection.viewMenuOnlyDiscount();
		Connection.viewMenuWhereWeightLessThan1kg();

		Connection.em.close();
		Connection.emf.close();
	}

}
