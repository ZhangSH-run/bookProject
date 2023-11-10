package book.service;

import book.pojo.Cart;
import book.pojo.Order;
import book.pojo.User;

import java.util.List;

public interface OrderService {
    List<Order> getOrderList(User user);

    void addOrder(Order order,Cart cart);

    Order getOrderById(Integer orderId);
}
