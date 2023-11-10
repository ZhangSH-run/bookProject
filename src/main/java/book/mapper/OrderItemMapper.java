package book.mapper;

import book.pojo.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    List<OrderItem> getOrderItemByOrderId(Integer id);

    void addOrderItem(OrderItem orderItem);
}
