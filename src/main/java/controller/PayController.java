package controller;

import domain.payment.PaymentType;
import domain.payment.discount.CategoryDiscount;
import domain.payment.discount.ChickenCategoryDiscount;
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

		CategoryDiscount categoryDiscount = new ChickenCategoryDiscount();
		double discountedMoney = categoryDiscount.calculateDiscountedMoney(payingTable);

		OutputView.printCurrentPayingTable(payingTable);
		OutputView.askPaymentType();
		PaymentType paymentType = PaymentType.of(InputView.inputInteger());
		discountedMoney = paymentType.calculateDiscountedMoney(discountedMoney);

		OutputView.printTotalMoney(discountedMoney);
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
