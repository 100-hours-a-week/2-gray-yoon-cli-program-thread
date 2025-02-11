package cafe.order;

import cafe.menu.MenuItem;

public class OrderItem {
    private int count;
    private MenuItem item;

    public OrderItem(int count, MenuItem item) {
        this.count = count;
        this.item = item;
    }

    public int getTotalPrice() {
        return count * item.getPrice();
    }

    public void makeItem(int orderNumber) {
        System.out.println("[주문번호: " + orderNumber + "] " + item.getName() + "을(를) 만드는 중...");
        System.out.println("[주문번호: " + orderNumber + "] " + item.getName() + "을(를) 완성했습니다!");
    }

    @Override
    public String toString() {
        return item.toString() + " - " + count + "개, 합계: " + getTotalPrice() + "원";
    }
}
