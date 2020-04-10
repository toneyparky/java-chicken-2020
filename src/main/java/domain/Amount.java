package domain;

public class Amount {
	private int amount;

	public Amount(int amount) {
		validate(amount);
		this.amount = amount;
	}

	private void validate(int amount) {
		if (amount < 1 || amount > 99) {
			throw new IllegalArgumentException("총 주문량은 1-99 사이여야합니다.");
		}
	}
}
