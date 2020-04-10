package controller;

import domain.Operation;
import domain.table.TableRepository;
import domain.table.Tables;
import view.InputView;
import view.OutputView;

public class PosController {
	Tables tables;

	public PosController() {
		this.tables = new Tables(TableRepository.tables());
	}

	public void operate() {
		OutputView.printOperations();
		OutputView.askOperation();

		Operation operation = Operation.of(InputView.inputInteger());

		if (operation.isOrder()) {
			OrderController orderController = new OrderController();
			orderController.operate(tables);
			operate();
		}

		if (operation.isPay()) {
			PayController payController = new PayController();
			payController.operate(tables);
			operate();
		}

		if (operation.isExit()) {
			OutputView.printExitMessage();
		}
	}
}
