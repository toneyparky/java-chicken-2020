package domain.table;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class TablesTest {

	@DisplayName("Tables 정상 생성 테스트")
	@Test
	void create() {
		assertThat(new Tables(TableRepository.tables())).isInstanceOf(Tables.class);
	}
}