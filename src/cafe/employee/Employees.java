package cafe.employee;

import cafe.order.OrderItem;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Employees {
    private final int EMPLOYEE_COUNT = 2;
    private final ExecutorService employees = Executors.newFixedThreadPool(EMPLOYEE_COUNT);

    public void makeOrders(ArrayList<OrderItem> orders) {
        CountDownLatch latch = new CountDownLatch(orders.size());

        // 스레드 풀 사용해서 make 처리
        for (int i = 0; i < orders.size(); i++) {
            OrderItem item = orders.get(i);
            Runnable task = new Task(i + 1, item, latch);

            employees.execute(task);
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        employees.shutdown();
    }
}
