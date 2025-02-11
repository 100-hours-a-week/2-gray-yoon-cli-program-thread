package cafe.employee;

import cafe.order.OrderItem;

import java.util.ArrayList;

public class Employees {
    private Employee employee1 = new Employee();
    private Employee employee2 = new Employee();

    public void makeOrders(ArrayList<OrderItem> orders) {
        int mid = orders.size() / 2;

        employee1.setMyOrders(0, orders.subList(0, mid));
        employee2.setMyOrders(mid, orders.subList(mid, orders.size()));

        Thread thread1 = new Thread(employee1);
        Thread thread2 = new Thread(employee2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
