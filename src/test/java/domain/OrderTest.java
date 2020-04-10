package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

	@DisplayName("Order 정상 생성 테스트")
	@Test
	void create() {
		assertThat(new Order(MenuRepository.menus().get(0), new Amount(10))).isInstanceOf(Order.class);
	}
}
