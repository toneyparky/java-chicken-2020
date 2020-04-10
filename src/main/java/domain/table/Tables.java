package domain.table;

import java.util.List;

public class Tables {
	private final List<Table> tables;

	public Tables(List<Table> tables) {
		this.tables = tables;
	}

	public List<Table> getTables() {
		return tables;
	}
}
