package domain.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PaymentTypeTest {
	@DisplayName("of 유효한 입력시 PaymentType 반환")
	@Test
	void of_When_valid_input_Return_PaymentType() {
		assertEquals(PaymentType.of(1), PaymentType.CREDIT_CARD);
	}

	@DisplayName("calculateDiscountedMoney 할인 비율에 맞게 할인")
	@Test
	void calculateDiscountedMoney_Discount_money_by_rate() {
		assertEquals(PaymentType.CREDIT_CARD.calculateDiscountedMoney(100_000), 95_000);
	}
}