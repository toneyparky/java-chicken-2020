package domain.order;

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

	public void add(Amount inputAmount) {
		validate(this.amount + inputAmount.amount);
		this.amount = this.amount + inputAmount.amount;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return String.valueOf(amount);
	}
}
