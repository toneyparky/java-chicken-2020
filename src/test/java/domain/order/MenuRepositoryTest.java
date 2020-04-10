package domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MenuRepositoryTest {

	@DisplayName("getByNumber 해당되는 번호의 메뉴를 찾으면 그 메뉴 반환 테스트")
	@Test
	void getByNumber_When_find_menu_Return_menu() {
		assertEquals(MenuRepository.getByNumber(1), MenuRepository.menus().get(0));
	}
}