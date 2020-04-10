package view;

import domain.order.Menu;
import domain.table.Table;

import java.util.List;

public class OutputView {
	private static final String TOP_LINE = "┌ ─ ┐";
	private static final String TABLE_FORMAT = "| %s |";
	private static final String BOTTOM_LINE = "└ ─ ┘";

	public static void askOrderTable() {
		System.out.println("## 주문할 테이블을 선택하세요.");
	}

	public static void printTables(final List<Table> tables) {
		System.out.println("## 테이블 목록");
		final int size = tables.size();
		printLine(TOP_LINE, size);
		printTableNumbers(tables);
		printLine(BOTTOM_LINE, size);
	}

	public static void printMenus(final List<Menu> menus) {
		for (final Menu menu : menus) {
			System.out.println(menu);
		}
	}

	private static void printLine(final String line, final int count) {
		for (int index = 0; index < count; index++) {
			System.out.print(line);
		}
		System.out.println();
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

	public static void printExitMessage() {
		System.out.println("Pos기를 종료합니다.");
	}
}
