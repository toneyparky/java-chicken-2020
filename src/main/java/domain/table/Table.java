package domain.table;

import domain.order.Orders;

public class Table {
    private final int number;
    private Orders orders = new Orders();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
