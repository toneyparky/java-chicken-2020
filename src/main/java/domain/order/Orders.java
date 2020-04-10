package domain.order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
	private List<Order> orders = new ArrayList<>();

	public Orders() {
	}

	public Orders(List<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order inputOrder) {
		if (!orders.contains(inputOrder)) {
			orders.add(inputOrder);
			return;
		}

		Order targetOrder = orders.stream()
				.filter(order -> order.equals(inputOrder))
				.findFirst()
				.orElse(inputOrder);

		targetOrder.addOrder(inputOrder);
	}

	public List<Order> getOrders() {
		return orders;
	}
}
