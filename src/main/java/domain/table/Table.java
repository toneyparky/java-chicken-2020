package domain.table;

import domain.order.Category;
import domain.order.Order;
import domain.order.Orders;

public class Table {
	private final int number;
	private Orders orders = new Orders();

	public Table(final int number) {
		this.number = number;
	}

	public void order(Order inputOrder) {
		orders.addOrder(inputOrder);
	}

	public void clear() {
		orders = new Orders();
	}

	public int countMenusBy(Category category) {
		return orders.countMenusBy(category);
	}

	public boolean isOrdered() {
		return orders.isOrdered();
	}

	public double calculateTotalPrice() {
		return orders.calculateTotalPrice();
	}

	public int getNumber() {
		return number;
	}

	public Orders getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		return Integer.toString(number);
	}

	@Override
	public boolean equals(Object o) {
		Table table = (Table) o;
		return number == table.number;
	}
}
