package domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {
	@DisplayName("isSameNumber 같은 number 입력시 true 반환")
	@Test
	void isSameNumber_When_same_number_input_Return_ture() {
		Menu menu = MenuRepository.getByNumber(1);
		assertTrue(menu.isSameNumber(1));
	}

	@DisplayName("isSameNumber 다른 number 입력시 false 반환")
	@Test
	void isSameNumber_When_different_number_input_Return_false() {
		Menu menu = MenuRepository.getByNumber(1);
		assertFalse(menu.isSameNumber(2));
	}

	@DisplayName("isSameCategory 같은 category 입력시 true 반환")
	@Test
	void isSameCategory_When_same_category_input_Return_true() {
		Menu menu = MenuRepository.getByNumber(1);
		assertTrue(menu.isSameCategory(Category.CHICKEN));
	}

	@DisplayName("isSameCategory 다른 category 입력시 false 반환")
	@Test
	void isSameCategory_When_different_category_input_Return_false() {
		Menu menu = MenuRepository.getByNumber(1);
		assertFalse(menu.isSameCategory(Category.BEVERAGE));
	}
}