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

	public int countMenusBy(Category category) {
		return orders.stream()
				.filter(order -> order.isSameCategory(category))
				.mapToInt(order -> order.getAmount().getAmount()) // TODO: 2020/04/10 겟 제거
				.sum();
	}

	public double calculateTotalPrice() {
		return orders.stream()
				.mapToDouble(order -> order.calculatePrice())
				.sum();
	}

	public boolean isOrdered() {
		return !orders.isEmpty();
	}

	public List<Order> getOrders() {
		return orders;
	}
}
