package domain.payment.discount;

import domain.order.Amount;
import domain.order.MenuRepository;
import domain.order.Order;
import domain.table.Table;
import domain.table.TableRepository;
import domain.table.Tables;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChickenCategoryDiscountTest {
	@Test
	void calculateDiscountedMoney_discount_chicken_menues() {

		Tables tables = new Tables(TableRepository.tables());

		Table table = tables.getTables().get(0);
		Order order = new Order(MenuRepository.menus().get(0), new Amount(10));

		table.order(order);

		ChickenCategoryDiscount chickenCategoryDiscount = new ChickenCategoryDiscount();
		assertEquals(chickenCategoryDiscount.calculateDiscountedMoney(table), 150_000);
	}
}