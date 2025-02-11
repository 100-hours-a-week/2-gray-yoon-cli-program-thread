package cafe.employee;

import cafe.order.OrderItem;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {
    private final int orderNumber;
    private final OrderItem item;
    private final CountDownLatch latch;

    public Task(int orderNumber, OrderItem item, CountDownLatch latch) {
        this.orderNumber = orderNumber;
        this.item = item;
        this.latch = latch;
    }

    @Override
    public void run() {
        item.makeItem(orderNumber);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        item.completeItem(orderNumber);

        latch.countDown();
    }
}
