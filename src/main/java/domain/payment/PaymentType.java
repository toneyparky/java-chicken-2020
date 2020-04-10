package domain.payment;

import java.util.Arrays;

public enum PaymentType {
	CREDIT_CARD(1, 0.95),
	CASH(2, 1);

	private final int number;
	private final double discountRate;

	PaymentType(int number, double discountRate) {
		this.number = number;
		this.discountRate = discountRate;
	}

	public static PaymentType of(int inputNumber) {
		return Arrays.stream(PaymentType.values())
				.filter(paymentType -> paymentType.number == inputNumber)
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("입력 숫자에 해당하는 지불 방식이 없습니다."));
	}

	public double calculateDiscountedMoney(double money) { // TODO: 2020/04/10 추후 함수형 인터페이스로
		return money * discountRate;
	}
}
