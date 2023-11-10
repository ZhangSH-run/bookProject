package book.service;

import book.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getOrderItemList(Integer orderId);

    void addOrderItem(OrderItem orderItem);

}
