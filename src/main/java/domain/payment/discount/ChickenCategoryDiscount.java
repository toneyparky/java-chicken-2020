package domain.payment.discount;

import domain.order.Category;
import domain.table.Table;

public class ChickenCategoryDiscount implements CategoryDiscount{
	@Override
	public double calculateDiscountedMoney(Table table) {
		int count = table.countMenusBy(Category.CHICKEN);

		return table.calculateTotalPrice() - ((count / 10) * 10_000);
	}
}
