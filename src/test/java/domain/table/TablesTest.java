package domain.table;

import domain.order.Amount;
import domain.order.MenuRepository;
import domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TablesTest {

	@DisplayName("Tables 정상 생성 테스트")
	@Test
	void create() {
		assertThat(new Tables(TableRepository.tables())).isInstanceOf(Tables.class);
	}

	@DisplayName("order 정상 입력시 작동 테스트")
	@Test
	void order_When_right_input_order() {
		Tables tables = new Tables(TableRepository.tables());
		Table table = tables.getTables().get(0);
		Order order = new Order(MenuRepository.menus().get(0), new Amount(10));

		tables.order(table, order);
		assertEquals(tables.getTables().get(0).getOrders().getOrders().get(0), order);
	}
}