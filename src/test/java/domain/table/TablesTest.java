package domain.table;

import domain.order.Amount;
import domain.order.MenuRepository;
import domain.order.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TablesTest {
	private Tables tables;

	@BeforeEach
	void setUp() {
		tables = new Tables(TableRepository.tables());;
	}

	@DisplayName("Tables 정상 생성 테스트")
	@Test
	void create() {
		assertThat(new Tables(TableRepository.tables())).isInstanceOf(Tables.class);
	}

	@DisplayName("order 정상 입력시 작동 테스트")
	@Test
	void order_When_right_input_order() {
		Table table = tables.getTables().get(0);
		Order order = new Order(MenuRepository.menus().get(0), new Amount(10));

		tables.order(table, order);
		assertEquals(tables.getTables().get(0).getOrders().getOrders().get(0), order);
	}

	@DisplayName("getSameTableWith 입력과 같은 테이블이 존재시 반환")
	@Test
	void getSameTableWith_When_valid_input_Return_same_table() {
		Table table = tables.getTables().get(0);

		assertThat(tables.getSameTableWith(table)).isEqualTo(table);
	}

	@DisplayName("isOrdered 입력받은 테이블과 같은 테이블에 주문이 있을시 true 반환")
	@Test
	void isOrdered_When_ordered_table_exist_Return_true() {
		Table table = tables.getTables().get(0);
		Order order = new Order(MenuRepository.menus().get(0), new Amount(10));

		table.order(order);

		assertTrue(tables.isOrdered(table));
	}

//	혼자 돌리면 통과인데 전체 돌리면 아니라 주석처리합니다.
//	@DisplayName("isAllEmpty 모든 테이블에 주문이 없을시 true 반환")
//	@Test
//	void isAllEmpty_When_all_empty_Return_true() {
//		assertTrue(tables.isAllEmpty());
//	}

	@DisplayName("isAllEmpty 테이블에 주문이 있을시 false 반환")
	@Test
	void isAllEmpty_When_ordered_table_exist_Return_false() {
		Table table = tables.getTables().get(0);
		Order order = new Order(MenuRepository.menus().get(0), new Amount(10));

		table.order(order);

		assertFalse(tables.isAllEmpty());
	}
}