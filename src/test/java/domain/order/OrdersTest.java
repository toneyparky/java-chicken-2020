package domain.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrdersTest {
	private List<Order> orders;

	@BeforeEach
	void setUp() {
		orders = new ArrayList<>();
		orders.add(new Order(MenuRepository.menus().get(0), new Amount(10)));
		orders.add(new Order(MenuRepository.menus().get(1), new Amount(10)));
	}

	@DisplayName("Orders 정상 생성 테스트")
	@Test
	void create() {
		assertThat(new Orders(orders)).isInstanceOf(Orders.class);
	}

	@DisplayName("addOrder 새로운 주문 입력시 추가 테스트")
	@Test
	void addOrder_When_new_order_Add_order() {
		Order order = new Order(MenuRepository.menus().get(2), new Amount(10));
		Orders actual = new Orders(orders);
		actual.addOrder(order);

		assertEquals(actual.getOrders().get(2), order);
	}

	@DisplayName("addOrder 기존 주문 입력시 추가로 주문 테스트")
	@Test
	void addOrder_When_exist_order_Add_more_exist_order() {
		Order order = new Order(MenuRepository.menus().get(0), new Amount(10));
		Orders actual = new Orders(orders);
		actual.addOrder(order);

		assertEquals(actual.getOrders().get(0).getAmount().getAmount(), 20);
	}
}