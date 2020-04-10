package domain.order;

import domain.order.Amount;
import domain.order.MenuRepository;
import domain.order.Order;
import domain.order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OrdersTest {

	@DisplayName("Orders 정상 생성 테스트")
	@Test
	void create() {
		List<Order> orders = Arrays.asList(
				new Order(MenuRepository.menus().get(0), new Amount(10)),
				new Order(MenuRepository.menus().get(2), new Amount(10))
		);
		assertThat(new Orders(orders)).isInstanceOf(Orders.class);
	}
}