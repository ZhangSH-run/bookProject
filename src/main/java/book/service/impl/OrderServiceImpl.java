package book.service.impl;

import book.mapper.OrderMapper;
import book.pojo.*;
import book.service.BookService;
import book.service.CartItemService;
import book.service.OrderItemService;
import book.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemService orderItemService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private BookService bookService;
    @Override
    public List<Order> getOrderList(User user) {
        List<Order> orderList = orderMapper.getOrderListByUserId(user.getId());
        for (Order order : orderList){
            List<OrderItem> orderItemList = orderItemService.getOrderItemList(order.getId());
            Integer totalBookCount = 0;
            for (OrderItem orderItem : orderItemList){
                totalBookCount += orderItem.getBuyCount();
            }
            order.setTotalBookCount(totalBookCount);
            order.setOrderItemList(orderItemList);
        }
        return orderList;
    }

    @Override
    public void addOrder(Order order,Cart cart) {
        orderMapper.addOrder(order);
        Collection<CartItem> cartItems = cart.getCartItemMap().values();
        OrderItem orderItem = new OrderItem();
        for (CartItem cartItem : cartItems){
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(order);
            orderItemService.addOrderItem(orderItem);
            cartItemService.delCartItem(cartItem);
        }

    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderMapper.getOrderById(orderId);
        List<OrderItem> orderItemList = orderItemService.getOrderItemList(orderId);
        Integer totalBookCount = 0;
        for (OrderItem orderItem : orderItemList){
            totalBookCount += orderItem.getBuyCount();
            Book book = bookService.getBookById(orderItem.getBook().getId());
            orderItem.setBook(book);
        }
        order.setTotalBookCount(totalBookCount);
        order.setOrderItemList(orderItemList);
        return order;
    }
}
