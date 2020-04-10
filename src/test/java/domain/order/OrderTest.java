package domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

	@DisplayName("Order 정상 생성 테스트")
	@Test
	void create() {
		assertThat(new Order(MenuRepository.menus().get(0), new Amount(10))).isInstanceOf(Order.class);
	}

	@DisplayName("isSameCategory 같은 category 입력시 true 반환")
	@Test
	void isSameCategory_When_same_category_input_Return_true() {
		Menu menu = MenuRepository.getByNumber(1);
		Order order = new Order(menu, new Amount(1));
		assertTrue(order.isSameCategory(Category.CHICKEN));
	}

	@DisplayName("isSameCategory 다른 category 입력시 false 반환")
	@Test
	void isSameCategory_When_different_category_input_Return_false() {
		Menu menu = MenuRepository.getByNumber(1);
		Order order = new Order(menu, new Amount(1));
		assertFalse(order.isSameCategory(Category.BEVERAGE));
	}

	@DisplayName("calculatePrice 해당 주문의 값을 반환")
	@Test
	void calculatePrice_Return_price() {
		Menu menu = MenuRepository.getByNumber(1);
		Order order = new Order(menu, new Amount(10));

		assertEquals(order.calculatePrice(), 160_000);
	}
}
