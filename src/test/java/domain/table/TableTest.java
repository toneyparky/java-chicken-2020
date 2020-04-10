package domain.table;

import domain.order.Amount;
import domain.order.MenuRepository;
import domain.order.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class TableTest {
	@DisplayName("clear 실행시 새로운 orders를 재할당")
	@Test
	void clear_Clean_table() {
		Tables tables = new Tables(TableRepository.tables());

		Table table = tables.getTables().get(0);
		Order order = new Order(MenuRepository.menus().get(0), new Amount(10));

		table.order(order);
		table.clear();

		assertFalse(table.isOrdered());
	}
}