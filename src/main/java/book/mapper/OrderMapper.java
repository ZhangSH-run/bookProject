package book.mapper;

import book.pojo.Order;

import java.util.List;

public interface OrderMapper {
    List<Order> getOrderListByUserId(Integer id);

    void addOrder(Order order);
}
