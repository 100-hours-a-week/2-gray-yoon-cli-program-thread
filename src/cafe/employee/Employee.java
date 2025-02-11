package cafe.employee;

import cafe.order.OrderItem;

import java.util.List;

public class Employee implements Runnable {
    private int orderStartNum;
    private List<OrderItem> orders;

    public void setMyOrders(int orderStartNum, List<OrderItem> orders) {
        this.orderStartNum = orderStartNum;
        this.orders = orders;
    }

    @Override
    public void run() {
        for (int i = 0; i < orders.size(); i++) {
            OrderItem menu = orders.get(i);
            menu.makeItem(orderStartNum + i + 1);

            try {
                Thread.sleep(500); // 1초 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
