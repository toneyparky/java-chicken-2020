package domain.order;

public class Order {
	private final Menu menu;
	private Amount amount;

	public Order(Menu menu, Amount amount) {
		this.menu = menu;
		this.amount = amount;
	}
}
