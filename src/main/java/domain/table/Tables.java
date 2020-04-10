package domain.table;

import domain.order.Order;

import java.util.List;

public class Tables {
	private final List<Table> tables;

	public Tables(List<Table> tables) {
		this.tables = tables;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void order(Table inputTable, Order order) {
		Table orderingTable  = tables.stream()
				.filter(table -> table.equals(inputTable))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("주문할 테이블을 찾을 수 없습니다."));

		orderingTable.order(order);
	}
}
