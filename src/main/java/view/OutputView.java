package view;

import domain.order.Menu;
import domain.order.Order;
import domain.order.Orders;
import domain.table.Table;

import java.util.List;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";
	private static final String ORDERED_BOTTOM_LINE = "└ ₩ ┘";

	public static void askOrderTable() {
		System.out.println("## 주문할 테이블을 선택하세요.");
	}

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printTopLine(size);
		printTableNumbers(tables);
		printBottomLine(tables);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printTopLine(final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(TOP_LINE);
		}
		System.out.println();
	}

	private static void printBottomLine(final List<Table> tables) {
		for (Table table : tables) {
			System.out.print(getBottomLine(table));
		}
		System.out.println();
	}

	private static String getBottomLine(Table table) {
		if (table.isOrdered()) {
			return ORDERED_BOTTOM_LINE;
		}
		return BOTTOM_LINE;
	}

	private static void printTableNumbers(final List<Table> tables) {
		for (final Table table : tables) {
			System.out.printf(TABLE_FORMAT, table);
		}
		System.out.println();
	}

	public static void printException(String message) {
		System.out.println(message);
	}

	public static void askOrderMenu() {
		System.out.println("## 등록할 메뉴를 선택하세요.");
	}

	public static void askOrderAmount() {
		System.out.println("## 메뉴의 수량을 입력하세요.");
	}

	public static void printOperations() {
		String message = String.join("\n",
				"## 메인화면",
				"1 - 주문등록",
				"2 - 결제하기",
				"3 - 프로그램 종료");
		System.out.println(message);
	}

	public static void askOperation() {
		System.out.println("## 원하는 기능을 선택하세요.");
	}

	public static void printNoOrderedTables() {
		System.out.println("주문된 테이블이 없어 실행할 수 없는 기능입니다.");
	}

	public static void printNotOrderedTable() {
		System.out.println("주문되지 않은 테이블입니다. 다시 입력해주세요.");
	}

	public static void printExitMessage() {
		System.out.println("Pos기를 종료합니다.");
	}

	public static void printPayingOrders(Orders orders) {
		System.out.println("## 주문내역");
		System.out.println("메뉴  수량  금액");
		for (Order order : orders.getOrders()) {
			System.out.println(order);
		}
	}

	public static void printTotalMoney(double totalMoney) {
		System.out.println(String.format("최종 금액은 %.0f원입니다.", totalMoney));
	}

	public static void printCurrentPayingTable(Table payingTable) {
		System.out.println(String.format("## %d번 테이블의 결제를 진행합니다.", payingTable.getNumber()));
	}

	public static void askPaymentType() {
		System.out.println("## 신용 카드는 1번, 현금은 2번");
	}
}
