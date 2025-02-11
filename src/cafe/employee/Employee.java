package cafe.employee;

import cafe.order.OrderItem;

import java.util.List;

public class Employee implements Runnable {
    private int orderNumber;
    private List<OrderItem> orders;

    public Employee(int orderNumber, List<OrderItem> orders) {
        this.orderNumber = orderNumber;
        this.orders = orders;
    }

    @Override
    public void run() {
        for (int i = 0; i < orders.size(); i++) {
            OrderItem menu = orders.get(i);
            menu.makeItem(orderNumber + i + 1);

            try {
                Thread.sleep(500); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
