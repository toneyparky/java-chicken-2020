package controller;

import domain.table.Table;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

public class PayController {
	public void operate(Tables tables) {
		if (tables.isAllEmpty()) {
			OutputView.printNoOrderedTables();
			return;
		}

		OutputView.printTables(tables.getTables());
		OutputView.askOrderTable();
		Table payingTable = getPayingTable(tables);

		OutputView.printPayingOrders(payingTable.getOrders());

		// TODO: 2020/04/10 할인 로직

		OutputView.printTotalMoney();
		payingTable.clear();
	}

	private Table getPayingTable(Tables tables) {
		Table payingTable = new Table(InputView.inputInteger());

		if (!tables.isOrdered(payingTable)) {
			OutputView.printNotOrderedTable();
			return getPayingTable(tables);
		}

		return tables.getSameTableWith(payingTable);
	}
}
