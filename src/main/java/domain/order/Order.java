package domain.order;

import java.util.Objects;

public class Order {
	private final Menu menu;
	private Amount amount;

	public Order(Menu menu, Amount amount) {
		this.menu = menu;
		this.amount = amount;
	}

	public void addOrder(Order inputOrder) {
		this.amount.add(inputOrder.amount);
	}

	public Amount getAmount() {
		return amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(menu, order.menu);
	}
}
