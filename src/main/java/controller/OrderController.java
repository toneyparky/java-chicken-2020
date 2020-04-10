package controller;

import domain.order.Amount;
import domain.order.Menu;
import domain.order.MenuRepository;
import domain.order.Order;
import domain.table.Table;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

import java.util.List;

public class OrderController {

	public void operate(Tables tables) {

		OutputView.printTables(tables.getTables());
		OutputView.askOrderTable();
		Table orderingTable = new Table(InputView.inputInteger());

		final List<Menu> menus = MenuRepository.menus();
		OutputView.printMenus(menus);

		OutputView.askOrderMenu();
		Menu orderingMenu = MenuRepository.getByNumber(InputView.inputInteger());

		OutputView.askOrderAmount();
		Amount orderingAmount = new Amount(InputView.inputInteger());

		Order order = new Order(orderingMenu, orderingAmount);

		tables.order(orderingTable, order);
	}
}
